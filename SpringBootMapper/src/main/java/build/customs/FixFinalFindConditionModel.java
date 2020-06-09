package build.customs;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixFinalFindConditionModel {
	
	private int startRow;
	private int endRow;
	private List<FinalSortModel> sortModel;
	private List<FinalFilterModel> filterModel;
	
	public FixFinalFindConditionModel(HashMap<String, Object> condition)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		for (Field field : this.getClass().getDeclaredFields())
		{
			field.setAccessible(true);
			try 
			{ 
				if (condition.containsKey(field.getName()) && condition.get(field.getName()) != null)
				{
					if (field.getName().equals("filterModel"))
					{
						List<FinalFilterModel> listfilter = new ArrayList<>();
						@SuppressWarnings("unchecked")
						HashMap<String, Object> hashmap = (HashMap<String, Object>) condition.get(field.getName());
						hashmap.keySet().forEach(key -> 
						{
							FinalFilterModel model = objectMapper.convertValue(hashmap.get(key), FinalFilterModel.class);
							model.setColId(key);
							listfilter.add(model);
						});
						field.set(this, listfilter);
					}
					else
					{
						if (field.getType().equals(List.class))
						{
							ParameterizedType typeList = (ParameterizedType) field.getGenericType();
							Class<?> genericClass = (Class<?>) typeList.getActualTypeArguments()[0];
							field.set(this,  objectMapper.convertValue(condition.get(field.getName()),
											objectMapper.getTypeFactory().constructCollectionType(List.class, genericClass)));
						}
						else
						{
							field.set(this, 
								  objectMapper.convertValue(condition.get(field.getName()), field.getType()));
						}
					}
				}
				else
				{
					if (field.getType().equals(List.class))
					{
						field.set(this, new ArrayList<>());
					}
				}
			} 
			catch (IllegalArgumentException | IllegalAccessException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public FixFinalFindConditionModel passData(HashMap<String, Object> condition)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		for (Field field : this.getClass().getDeclaredFields())
		{
			field.setAccessible(true);
			try 
			{ 
				if (condition.containsKey(field.getName()) && condition.get(field.getName()) != null)
				{
					if (field.getName().equals("filterModel"))
					{
						List<FinalFilterModel> listfilter = new ArrayList<>();
						@SuppressWarnings("unchecked")
						HashMap<String, Object> hashmap = (HashMap<String, Object>) condition.get(field.getName());
						hashmap.keySet().forEach(key -> 
						{
							FinalFilterModel model = objectMapper.convertValue(hashmap.get(key), FinalFilterModel.class);
							model.setColId(key);
							listfilter.add(model);
						});
						field.set(this, listfilter);
					}
					else
					{
						if (field.getType().equals(List.class))
						{
							ParameterizedType typeList = (ParameterizedType) field.getGenericType();
							Class<?> genericClass = (Class<?>) typeList.getActualTypeArguments()[0];
							field.set(this,  objectMapper.convertValue(condition.get(field.getName()),
											objectMapper.getTypeFactory().constructCollectionType(List.class, genericClass)));
						}
						else
						{
							field.set(this, 
								  objectMapper.convertValue(condition.get(field.getName()), field.getType()));
						}
					}
				}
				else
				{
					if (field.getType().equals(List.class))
					{
						field.set(this, new ArrayList<>());
					}
				}
			} 
			catch (IllegalArgumentException | IllegalAccessException e) 
			{
				e.printStackTrace();
			}
		}
		return this;
	}
	
	public FixFinalFindConditionModel convertHashMapToModel(HashMap<String, Object> rawModel)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		try
		{
			FixFinalFindConditionModel model = objectMapper.convertValue(rawModel, FixFinalFindConditionModel.class);
			this.startRow = model.getStartRow();
			this.endRow = model.getEndRow();
			this.sortModel = model.getSortModel();
			this.filterModel = model.getFilterModel();
		}
		catch (Exception e)
		{
			this.startRow = 0;
			this.endRow = 0;
			this.sortModel = new ArrayList<>();  
			this.filterModel = new ArrayList<>();
		}
		return this;
	}
	
	public FixFinalFindConditionModel convertData(HashMap<String, Object> rawModel)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		try
		{
			FixFinalFindConditionModel model = objectMapper.convertValue(rawModel, FixFinalFindConditionModel.class);
			this.startRow = model.getStartRow();
			this.endRow = model.getEndRow();
			this.sortModel = model.getSortModel();
			this.filterModel = model.getFilterModel();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
			try
			{
				this.startRow = objectMapper.convertValue(rawModel.get("startRow"), Integer.class);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
				this.startRow = 0;
			}
			
			try
			{
				this.endRow = objectMapper.convertValue(rawModel.get("endRow"), Integer.class);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
				this.endRow = 0;
			}
			
			try
			{
				//Set check null or it will convert null to sortModel (sortModel = null)
				this.sortModel = rawModel.get("sortModel") == null 
						? new ArrayList<>()
						: objectMapper.convertValue(rawModel.get("sortModel"), 
						objectMapper.getTypeFactory().constructCollectionType(List.class, FinalSortModel.class));
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
				this.sortModel = new ArrayList<>();
			}
			 
			try 
			{
				this.filterModel = new ArrayList<>();
				@SuppressWarnings("unchecked")
				HashMap<String, Object> hashmap = rawModel.get("filterModel") == null
				? new HashMap<>() : (HashMap<String, Object>) rawModel.get("filterModel");
				
				//Set check null for hashmap.forEach will not throw error
				hashmap.keySet().forEach(key -> 
				{
					FinalFilterModel model = objectMapper.convertValue(hashmap.get(key), FinalFilterModel.class);
					model.setColId(key);
					this.filterModel.add(model);
				});
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
				this.filterModel = new ArrayList<>();
			}
		}
		return this;
	}
	
	public FixFinalFindConditionModel standardizeFilterModel(Class<?> entityClass)
	{
		if (this.filterModel != null)
		{
			this.filterModel.forEach(filterModel -> 
			{
				//Parse Number Type (Int, Double)
				//only have filterType : 'text' or filterType : 'date'
				//must set filterType : 'numberInt' or filterType : 'numberDouble'
				for (Field field : entityClass.getDeclaredFields())
				{
					field.setAccessible(true);
					try 
					{ 
						if (filterModel.getColId().equals(field.getName()))
						{
							if (field.getType().equals(Integer.class))
							{
								filterModel.setFilter(Integer.parseInt(filterModel.getFilter().toString()));
								filterModel.setFilterType("numberInt");
							}
							if (field.getType().equals(Double.class))
							{
								filterModel.setFilter(Double.parseDouble(filterModel.getFilter().toString()));
								filterModel.setFilterType("numberDouble");
							}
							if (field.getType().equals(Boolean.class))
							{
								filterModel.setFilterType("boolean");
							}
							if (field.getType().equals(Date.class))
							{
								filterModel.setFilterType("date");
							}
							if (field.getType().equals(String.class))
							{
								filterModel.setFilterType("text");
							}
							if (field.getType().equals(ObjectId.class))
							{
								filterModel.setFilterType("objectid");
							}
						}
					} 
					catch (IllegalArgumentException e) 
					{
						e.printStackTrace();
					}
				}
				
			});
		}
		return this;
	}
	
	public FixFinalFindConditionModel addSort(FinalSortModel model)
	{
		if (this.sortModel == null)
		{
			this.sortModel = new ArrayList<>();
		}
		this.sortModel.add(model);
		return this;
	}
	
	public FixFinalFindConditionModel addFilter(FinalFilterModel model)
	{
		if (this.filterModel == null)
		{
			this.filterModel = new ArrayList<>();
		}
		this.filterModel.add(model);
		return this;
	}
}
