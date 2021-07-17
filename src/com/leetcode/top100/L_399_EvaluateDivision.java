package com.leetcode.top100;

import java.util.*;

public class L_399_EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[] result = new double[queries.size()];
        HashMap<String, Integer> indexMap = new HashMap<>();
        int length = equations.size();

        UnionFind unionFind = new UnionFind(length);

        // 1. 预处理， 将变量的值与id进行映射
        int id = 0;
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if (!indexMap.containsKey(a)) {
                indexMap.put(a, id);
                id++;
            }

            if (!indexMap.containsKey(b)) {
                indexMap.put(b, id);
                id++;
            }

            unionFind.union(indexMap.get(a), indexMap.get(b), values[i]);
        }

        // 2. 做查询
        int queriesSize = queries.size();
        for (int i = 0; i < queriesSize; i++) {

            result[i] = -1;
            String c = queries.get(i).get(0);
            String d = queries.get(i).get(1);

            if (indexMap.containsKey(c) && indexMap.containsKey(d)) {
                int parentC = unionFind.find(indexMap.get(c)); // 查找c的父节点，这样在查找的过程中，就会进行路径压缩
                int parentD = unionFind.find(indexMap.get(d)); // 主要是为了进行路径压缩
                double weightC = unionFind.weights[indexMap.get(c)];
                double weightD = unionFind.weights[indexMap.get(d)];
                if (parentC == parentD) { // 重点，必须在同一个连通分量里面
                    result[i] = weightC / weightD;
                }
            }

        }


        return result;
    }

    public class UnionFind {

        int[] parents;
        double[] weights;

        public UnionFind(int size) {
            parents = new int[2 * size];
            weights = new double[2 * size];
            // 并查集 初始状态， 每个节点的父节点为它自己。权重为1
            for (int i = 0; i < size * 2; i++) {
                parents[i] = i;
                weights[i] = 1;
            }

        }

        public int find(int p) {
            if (p != parents[p]) {
                int originParent = parents[p];
                parents[p] = find(parents[p]); // 把节点p的父节点换成了它的父节点的父节点，进行了路径压缩
                // 在查找的时候，进行了路径压缩，所以对应的权重也得更新
                weights[p] = weights[p] * weights[originParent];
            }
            return parents[p];
        }

        /**
         * 合并的重要前提： 两棵树的最大高度为2
         * 在union完后，树的高度可能会为3，但是在查询的时候，会进行路径压缩，所以最后还是指向根节点
         * @param x
         * @param y
         * @param value
         */
        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }
            // 两个树的最大高度为2，这是由于本题的性质决定的。所以无需判断rootX和rootY的rank
            parents[rootX] = rootY;
            // 更新权值 ，具体图可参看LeetCode官方图解
            weights[rootX] = value * weights[y] / weights[x];
        }

    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        l1.add("a");
        l1.add("b");
        l2.add("b");
        l2.add("c");
        equations.add(l1);
        equations.add(l2);

        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(Arrays.asList("a","c")));
        queries.add(new ArrayList<>(Arrays.asList("b","a")));
        queries.add(new ArrayList<>(Arrays.asList("a","e")));
        queries.add(new ArrayList<>(Arrays.asList("a","a")));
        queries.add(new ArrayList<>(Arrays.asList("x","x")));

        L_399_EvaluateDivision evaluateDivision = new L_399_EvaluateDivision();
        double[] result = evaluateDivision.calcEquation(equations, values, queries);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

}
