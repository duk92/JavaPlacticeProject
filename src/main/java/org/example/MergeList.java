package org.example;

import java.util.*;

    public class MergeList {

        public static void main(String[] args) {
            /*
            * dev brunch Commit
            * */
            List<Map<String, Object>> list1 = new ArrayList<>(); // 요청 데이터
            List<Map<String, Object>> list2 = new ArrayList<>(); // DB 저장 데이터

            // DB에 있는 기존 데이터 (list2) - D값 없음
            list2.add(createMap(1, 20, 30)); // A=1
            list2.add(createMap(5, 60, 70)); // A=5
            list2.add(createMap(9, 10, 11)); // A=9

            // 요청 데이터 (list1) - D값 있음
            list1.add(createMap(1, 2, 3, "E")); // A=1 (수정)
            list1.add(createMap(5, 0, 0, "D")); // A=5 (삭제)
            list1.add(createMap(7, 8, 9, "I")); // A=7 (추가)

            // 리스트 병합 및 처리
            List<Map<String, Object>> mergedList = mergeLists(list1, list2);

            // 결과 출력
            System.out.println("===== 최종 병합 결과 =====");
            for (Map<String, Object> map : mergedList) {
                System.out.println(map);
            }
        }

        // Map 생성 헬퍼 메서드 (list2에는 D 값 없음)
        private static Map<String, Object> createMap(int a, int b, int c) {
            Map<String, Object> map = new HashMap<>();
            map.put("A", a);
            map.put("B", b);
            map.put("C", c);
            return map;
        }

        // 요청 데이터용 Map 생성 (D 값 포함)
        private static Map<String, Object> createMap(int a, int b, int c, String d) {
            Map<String, Object> map = createMap(a, b, c);
            map.put("D", d);
            return map;
        }

        // 리스트 병합 및 처리 로직
        public static List<Map<String, Object>> mergeLists(List<Map<String, Object>> list1, List<Map<String, Object>> list2) {
            Map<Object, Map<String, Object>> resultMap = new LinkedHashMap<>();
            Map<Object, String> changeLog = new LinkedHashMap<>(); // 변경 내역 저장

            // DB 데이터를 먼저 저장 (D 값 없음)
            for (Map<String, Object> item : list2) {
                resultMap.put(item.get("A"), new HashMap<>(item)); // 기존 데이터 저장
            }

            // 요청 데이터 처리
            for (Map<String, Object> item : list1) {
                String action = (String) item.get("D");
                Object key = item.get("A");

                if ("D".equals(action)) {
                    // 삭제 처리
                    if (resultMap.containsKey(key)) {
                        resultMap.remove(key);
                        changeLog.put(key, "삭제됨");
                    }
                } else if ("E".equals(action)) {
                    // 수정 처리 (A 값이 존재하면 B, C 값만 업데이트)
                    if (resultMap.containsKey(key)) {
                        //Map<String, Object> existing = resultMap.get(key);
                        resultMap.get(key).put("B", item.get("B"));
                        resultMap.get(key).put("C", item.get("C"));
                        changeLog.put(key, "수정됨");
                    }
                } else if ("I".equals(action)) {
                    // 추가 처리
                    resultMap.put(key, item);
                    changeLog.put(key, "추가됨");
                }
            }

            // 변경 내역 출력
            System.out.println("===== 변경 내역 =====");
            for (Map.Entry<Object, String> entry : changeLog.entrySet()) {
                System.out.println("A=" + entry.getKey() + " → " + entry.getValue());
            }

            // 결과 리스트 반환
            return new ArrayList<>(resultMap.values());
        }

    }


