package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class loopFunctionTest {

    public void listMap(){

        Map<String, Object> rtnMap = null;
        List<Map<String, Object>> list = creatList(); // 요청 데이터
        List<Map<String, Object>> emptyList =  new ArrayList<>(); // 요청 데이터
        List<Map<String, Object>> existsList = new ArrayList<>(); // 요청 데이터

        List<Map<String, Object>> compList = new ArrayList<>(); // 요청 데이터

        int i = 0;
        for(Map<String,Object> map : list){
                rtnMap = new HashMap<>();
            if(i == 0){
                rtnMap.put("A",map.get("A"));
                rtnMap.put("B",map.get("B"));
                rtnMap.put("C",map.get("C"));
                int cnt = emptyListCnt(rtnMap);
                if(cnt > 0){
                    emptyList.add(rtnMap);
                }

            }else if(i == 1){
                rtnMap.put("A",map.get("A"));
                rtnMap.put("B",map.get("B"));
                rtnMap.put("C",map.get("C"));

                int cnt = emptyListCnt(rtnMap);
                if(cnt > 0){
                    emptyList.add(rtnMap);
                }

            }else if(i == 2){
                rtnMap.put("A",map.get("A"));
                rtnMap.put("B",map.get("B"));
                rtnMap.put("C",map.get("C"));

                int cnt = emptyListCnt(rtnMap);
                if(cnt > 0){
                    existsList.add(rtnMap);
                }
            }else if(i == 3){
                rtnMap.put("A",map.get("A"));
                rtnMap.put("B",map.get("B"));
                rtnMap.put("C",map.get("C"));
            }else if(i == 4){
                rtnMap.put("A",map.get("A"));
                rtnMap.put("B",map.get("B"));
                rtnMap.put("C",map.get("C"));
            }else if(i == 5){
                rtnMap.put("A",map.get("A"));
                rtnMap.put("B",map.get("B"));
                rtnMap.put("C",map.get("C"));
            }

            i++;

            if(emptyList.size() > 0 || existsList.size() > 0){

            }else{
                compList.add(rtnMap);
            }
        }

        if(emptyList.size() > 0 ){
            System.out.println("commit");
        }


    }

    private int emptyListCnt(Map<String,Object> param){

        int cnt = 0;

        if(!"3".equals(param.get("A"))){

            cnt = 1;
        }

        return cnt;
    }

    private int existsListCnt(Map<String,Object> param){

        int cnt = 0;

        if("9".equals(param.get("A")) || "1".equals(param.get("A"))){

            cnt = 1;
        }

        return cnt;
    }

    private Map<String, Object> createMap(int a, int b, int c) {

        Map<String, Object> map = new HashMap<>();
        map.put("A", a);
        map.put("B", b);
        map.put("C", c);

        return map;
    }

    private List<Map<String,Object>> creatList(){
        List<Map<String, Object>> list = new ArrayList<>(); // 요청 데이터

        list.add(createMap(1, 20, 30)); // A=1
        list.add(createMap(5, 60, 70)); // A=5
        list.add(createMap(9, 10, 11)); // A=9
        list.add(createMap(10, 30, 80)); // A=1
        list.add(createMap(14, 110, 90)); // A=5
        list.add(createMap(19, 70, 10)); // A=9

        return list;
    }


}
