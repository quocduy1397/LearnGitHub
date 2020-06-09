package build.controllers;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.mongodb.core.query.UntypedExampleMatcher;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import build.customs.FixFinalFindConditionModel;
import build.interfaces.PartnerInterfacesRepository;
import build.mappers.PartnerMapper;
import build.mappers.PartnerMapperSpring;
import build.models.Partner;
import build.models.PartnerDTO;
import build.repositories.DataRepository;

@RestController
@RequestMapping("/partner")
public class PartnerController {
	
	@Autowired
	private PartnerInterfacesRepository repository;
	
	@Autowired
	private DataRepository data;
	
	@Autowired
	private PartnerMapperSpring springMapper;
	
	@RequestMapping(value = "/testExampleSearch", method = RequestMethod.GET)
	public HashMap<String, Object> testExampleSreach(@RequestBody HashMap<String, Object> condition) 
	{
		FixFinalFindConditionModel findCondition = new FixFinalFindConditionModel();
		findCondition.convertData(condition);
		findCondition.standardizeFilterModel(Partner.class);
		Partner model = new Partner();
		for (Field field : model.getClass().getDeclaredFields())
		{
			field.setAccessible(true);
			findCondition.getFilterModel().forEach(element -> 
			{
				if (field.getName().equals(element.getColId()))
				{
					try 
					{
						field.set(model, element.getFilter());
					} 
					catch (IllegalArgumentException | IllegalAccessException e) 
					{
						e.printStackTrace();
					}
				}
			});
		}
		
		UntypedExampleMatcher matcher = UntypedExampleMatcher.matching().withIncludeNullValues();
		findCondition.getFilterModel().forEach(element -> 
		{
			switch (element.getType())
			{
				case "Equals" : 
					matcher.withMatcher(element.getColId(), ExampleMatcher.GenericPropertyMatchers.ignoreCase());
					break;
				case "Contains" : 
					matcher.withMatcher(element.getColId(), new GenericPropertyMatcher().regex());
					break;
				default : break;
			}
		});
		
		UntypedExampleMatcher matcher2 = UntypedExampleMatcher.matching().withIncludeNullValues()
				.withMatcher("partnerID", ExampleMatcher.GenericPropertyMatchers.ignoreCase())
				.withMatcher("partnerNameAbbr", new GenericPropertyMatcher().regex());
		
		Example<Partner> example = Example.of(model, matcher2);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("totalRows", repository.count(example));
		map.put("results", repository.findAll(example));
		
		
		PartnerMapper mapper = PartnerMapper.INSTANCE;
		List<Partner> list = repository.findAll(example);
		
		List<PartnerDTO> spring = list.stream()
				.map(item -> springMapper.partnerToDTO(item, data.getPartnerSource(item.getSource()), data.getCountry(item.getCountry())))
				.collect(Collectors.toList());
		spring.clear();
		
		List<PartnerDTO> dto = list.stream()
				.map(item -> mapper.partnerToDTO(item, data.getPartnerSource(item.getSource()), data.getCountry(item.getCountry())))
				.collect(Collectors.toList());
		map.put("check", dto);
		return map;
	}
}
