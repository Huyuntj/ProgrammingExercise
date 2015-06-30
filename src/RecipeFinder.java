import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RecipeFinder {

	private List<RecipeItem> itemsInFridge = new ArrayList<RecipeItem>();
	private Map<String, List<RecipeItem>> recipeCollections = new HashMap<String, List<RecipeItem>>();

	public String getDate() {
		Calendar calendar = Calendar.getInstance();
		if (calendar.get(Calendar.MONTH) + 1 < 10) {
			return calendar.get(Calendar.DAY_OF_MONTH) + "/0"
					+ (calendar.get(Calendar.MONTH) + 1) + "/"
					+ calendar.get(Calendar.YEAR);
		} else {
			return calendar.get(Calendar.DAY_OF_MONTH) + "/"
					+ (calendar.get(Calendar.MONTH) + 1) + "/"
					+ calendar.get(Calendar.YEAR);
		}

	}

	public boolean isValid(String s) {
		return (s != null) && (s.length() > 0);
	}

	public void readJsonFile(String filePath) {
		System.out.println("-----start to read data from " + filePath);
		JSONParser parse = new JSONParser();
		try {
			Object obj = parse.parse(new FileReader(filePath));
			JSONArray ingredients = (JSONArray) obj;
			if (ingredients != null && ingredients.size() != 0) {
				Iterator<JSONObject> iterator = ingredients.iterator();
				while (iterator.hasNext()) {
					boolean isDataValid = true;
					JSONObject next = iterator.next();
					String ingredientName = (String) next.get("name");
					if (isValid(ingredientName)) {
						JSONArray items = (JSONArray) next.get("ingredients");
						if (items != null && items.size() > 0) {
							Iterator<JSONObject> it = items.iterator();
							List<RecipeItem> itemList = new ArrayList<RecipeItem>();
							while (it.hasNext()) {
								JSONObject ingredient = it.next();
								String item = (String) ingredient.get("item");
								String amount = (String) ingredient
										.get("amount");
								String unit = (String) ingredient.get("unit");
								if (isValid(item) && isValid(amount)
										&& isValid(unit)) {
									RecipeItem ri = new RecipeItem(item,
											amount, unit, getDate());
									itemList.add(ri);
								} else {
									isDataValid = false;
									System.out.println(ingredientName
											+ " has valid ingredient");
									break;
								}

							}
							if (isDataValid) {
								recipeCollections.put(ingredientName, itemList);
							}
						} else {
							System.out.println("No ingredients for "
									+ ingredientName);
						}
					} else {
						System.out
								.println("Name of ingredients can't be null!");
					}
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("can't find file with path: " + filePath);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (org.json.simple.parser.ParseException e) {
			System.out.println(e.getMessage());
		}

	}

	public void readCSVFile(String filePath) throws ParseException {
		System.out.println();
		System.out.println("-----start to read data from " + filePath);
		FileReader fr = null;
		BufferedReader br = null;
		String line = "";
		try {
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {// the format of line is
													// like
													// "bread, 20, slices,25/12/2015",
													// so we have to remove ""
													// first
				if (line.length() <= 2) {
					System.out.println(line + ", this format is not correct!");
				}
				String[] items = line.substring(1, line.length() - 2)
						.split(",");
				if (items != null && items.length == 4) {
					RecipeItem item = new RecipeItem(items[0].trim(),
							items[1].trim(), items[2].trim(), items[3].trim());
					itemsInFridge.add(item);
				} else {
					System.out.println(line + ", this format is not correct!");
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
			if (br != null) {

				try {
					br.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}

	}

	public void findRecipe() {
		Iterator<String> it = recipeCollections.keySet().iterator();
		boolean findOneRecipe = false;
		while (it.hasNext()) {
			String name = it.next();
			List<RecipeItem> list = recipeCollections.get(name);
			Iterator<RecipeItem> listIt = list.iterator();
			boolean recipeMatch = true;
			while (listIt.hasNext()) {
				RecipeItem item = listIt.next();
				boolean findIt = false;
				for (int i = 0; i < itemsInFridge.size(); i++) {
					if (itemsInFridge.get(i).match(item)) {
						findIt = true;
						//continue;
						break;
					}
				}
				;
				if (findIt == false) {
					recipeMatch = false;
					break;
				}
			}
			if (recipeMatch == true) {
				System.out.println();
				System.out.println("-----Result is: " + name);
				findOneRecipe = true;
				break;
			}
		}

		if (findOneRecipe == false) {
			System.out.println("Order Takeout");
		}
	}

	public static void main(String[] args) {
		RecipeFinder rf = new RecipeFinder();

		try {
			rf.readJsonFile("C:\\Users\\I069194\\Desktop\\recipes.json");
			rf.readCSVFile("C:\\Users\\I069194\\Desktop\\fridge.csv");
			rf.findRecipe();
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		;
	}

}
