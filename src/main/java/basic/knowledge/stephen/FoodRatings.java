package basic.knowledge.stephen;

import java.util.ArrayList;
import java.util.HashMap;

public class FoodRatings {
    public static void main(String[] args) {
        String[] foods = {"kimchi","miso","sushi","moussaka","ramen","bulgogi"};
        String[] cu = {"korean","japanese","japanese","greek","japanese","korean"};
        int[] ratings = {9,12,8,15,14,7};
        FoodRatings foodRatings = new FoodRatings(foods,cu,ratings);

        String korean = foodRatings.highestRated("korean");
        foodRatings.changeRating("sushi",16);
        String res = foodRatings.highestRated("japanese");
        System.out.println(res);

    }


    HashMap<String,Integer> idxMap;
    HashMap<String,ArrayList<String>> cuMap;
    String[] foods;
    String[] cuisines;
    int[] ratings;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.idxMap = new HashMap<>();
        this.cuMap = new HashMap<>();
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;

        for(int i = 0;i< foods.length;i++){
            idxMap.put(foods[i],i);
        }

        for(int i = 0;i< foods.length;i++){
            String cuName = cuisines[i];
            String name = foods[i];
            ArrayList<String> list = cuMap.getOrDefault(cuName,new ArrayList<>());
            list.add(name);
            cuMap.put(cuName,list);
        }

    }

    public void changeRating(String food, int newRating) {
        if(idxMap.containsKey(food)){
            int idx = idxMap.get(food);
            this.ratings[idx] = newRating;
        }
    }

    public String highestRated(String cuisine) {
        String ans = "";
        if(cuMap.containsKey(cuisine)){


            ArrayList<String> list = cuMap.get(cuisine);
            ans = list.get(0);
            int max = this.ratings[this.idxMap.get(ans)];
            for(int i = 1; i< list.size();i++){
                String cur = list.get(i);
                int idx = this.idxMap.get(cur);
                if(this.ratings[idx] > max || (this.ratings[idx] == max && cur.compareTo(ans) < 0)){
                    max = this.ratings[idx];
                    ans = cur;
                }
            }
        }
        return ans;
    }
}
