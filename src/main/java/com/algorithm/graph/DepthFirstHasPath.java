package com.algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javatuples.Pair;

/**
 * https://www.youtube.com/watch?v=tWVWeAqZ0WU
 *
 */
public class DepthFirstHasPath {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<Pair<String, String>> listEdges = new ArrayList<Pair<String, String>>();
        Map<String, List<String>> mapEdges = new HashMap<String, List<String>>();
        Set<String> visited = new HashSet<String>();
        listEdges.add(new Pair<String, String>("a", "b")); 
        listEdges.add(new Pair<String, String>("a", "f"));
        listEdges.add(new Pair<String, String>("a", "c"));
        listEdges.add(new Pair<String, String>("b", "c"));
        listEdges.add(new Pair<String, String>("c", "d"));
        listEdges.add(new Pair<String, String>("d", "e"));
        listEdges.add(new Pair<String, String>("e", "f"));
        listEdges.add(new Pair<String, String>("i", "k"));

        System.out.println("List of Edge:" + listEdges);
        adjacencyMatrix(listEdges, mapEdges);
        System.out.println(mapEdges);
        System.out.println(hasPath(mapEdges,visited,"a", "d"));

    }

    public static void adjacencyMatrix(List<Pair<String, String>> listEdges, Map<String, List<String>> mapEdges){
        for(Pair<String, String> p : listEdges){
            String value0 = p.getValue0();
            String value1 = p.getValue1();
            addToAdjacencyList(mapEdges, value0, value1);
            addToAdjacencyList(mapEdges, value1, value0);
        }
    }

    private static void addToAdjacencyList(Map<String, List<String>> mapEdges, String value0, String value1) {
        if(mapEdges.get(value0) == null){
            List<String> adjList = new ArrayList<String>();
            adjList.add(value1);
            mapEdges.put(value0, adjList);
        } else{
            List<String> adjList = mapEdges.get(value0);
            adjList.add(value1);
        }
    }

    private static boolean hasPath(Map<String, List<String>> mapEdges,Set<String> visited, String src, String dest) {
        if(src.equals(dest)){
            return true;
        }

        String currentNode = src;
        List<String> listAdjEdge = mapEdges.get(currentNode);

        for (String node : listAdjEdge) {
            if(!visited.contains(node)){
                System.out.println(node);
                visited.add(node);
                return hasPath(mapEdges, visited, node, dest);
            }
        }
        
        return false;
    }
}
