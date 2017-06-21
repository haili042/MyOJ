package com.haili.xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T3 {

	public T3() {}

//	public static void main(String[] args) {
//		Scanner cin = new Scanner(System.in);
//		int n = cin.nextInt();
//		cin.nextLine();
//		int arr[][] = new int[n][n];
//		for (int i = 0; i < n; i++) {
//			String line = cin.nextLine();
//			String[] split = line.split(",");
//			for (int j = 0; j < split.length; j++) {
//				arr[i][j] = Integer.parseInt(split[j]);
//			}
//		}
//		System.out.println(5);
//		cin.close();
//	}

	public void dijkstra(int n, int v, int dist[], int prev[], int[][] c) {
		int maxint = Integer.MAX_VALUE;
		;
		boolean[] s = new boolean[n]; // ��¼�õ��Ƿ񱻷��ʹ�
		for (int i = 0; i < n; i++) {
			dist[i] = c[v][i]; // ��ʼ��
			s[i] = false;
			if (dist[i] == maxint) {
				prev[i] = 0;
			} else {
				prev[i] = v; // ��ʼ��
			}
		}
		dist[v] = 0;
		s[v] = true; // �����ʹ�
		for (int i = 0; i < n + 1; i++) {
			int temp = maxint;
			int u = v;
			for (int j = 0; j < n; j++) {
				if ((!s[j]) && (dist[j] < temp)) {
					u = j; // �õ����·�����յ�
					temp = dist[j];
				}
			}
			s[u] = true;
			for (int j = 0; j < n; j++) {
				if ((!s[j]) && (c[u][j] < maxint)) {
					int newdist = dist[u] + c[u][j];
					if (newdist < dist[j]) {
						dist[j] = newdist; // �µ����·��
						prev[j] = u; // ���·������һ����
					}
				}
			}
		}
	}

	public static int dijkstra(int[][] W1, int start, int end) { 
        boolean[] isLabel = new boolean[W1[0].length];// �Ƿ��� 
        int min = Integer.MAX_VALUE; 
        int[] indexs = new int[W1[0].length];// ���б�ŵĵ���±꼯�� 
        int i_count = -1; 
        int index = start;// �ӳ�ʼ�㿪ʼ 
        int presentShortest = 0; 
        int[] distance = W1[start].clone();// v0���������̾���ĳ�ʼֵ 
        indexs[++i_count] = index;// ���Ѿ���ŵ��±�����±꼯�� 
        isLabel[index] = true; 
        while (true) { 
            // ��һ�������v0,��w[0][0]�ҵ�����v0����ĵ� 
 
            min = Integer.MAX_VALUE; 
            for (int i = 0; i < distance.length; i++) { 
                if (!isLabel[i] && distance[i] != -1 && i != index) { 
                    // �����������б�,����û�б���� 
                    if (distance[i] < min) { 
                        min = distance[i]; 
                        index = i;// ���±��Ϊ��ǰ�±� 
                    } 
                } 
            } 
            if (index == end) { 
                break; 
            } 
            isLabel[index] = true; 
            indexs[++i_count] = index;// ���Ѿ���ŵ��±�����±꼯�� 
            if (W1[indexs[i_count - 1]][index] == -1
                    || presentShortest + W1[indexs[i_count - 1]][index] > distance[index]) { 
                presentShortest = distance[index]; 
            } else { 
                presentShortest += W1[indexs[i_count - 1]][index]; 
            } 
 
            // �ڶ�������distance�еľ������vi 
            for (int i = 0; i < distance.length; i++) { 
                // ���vi���Ǹ����бߣ���v0�������ľ���� 
                // ����������������Σ� �Ǻ� 
                if (distance[i] == -1 && W1[index][i] != -1) {// �����ǰ���ɴ�����ڿɴ��� 
                    distance[i] = presentShortest + W1[index][i]; 
                } else if (W1[index][i] != -1
                        && presentShortest + W1[index][i] < distance[i]) { 
                    // �����ǰ�ɴ�����ڵ�·������ǰ���̣�������ɸ��̵�·�� 
                    distance[i] = presentShortest + W1[index][i]; 
                } 
 
            } 
        } 
        return distance[end] - distance[start]; 
    } 
  
    public static int[][] getShortestPathMatrix(int[][] W) { 
        int[][] SPM = new int[W.length][W.length]; 
        //�������dijkstra�㷨 
        for (int i = 0; i < W.length; i++) { 
            for (int j = i + 1; j < W.length; j++) { 
                SPM[i][j] =dijkstra(W, i, j); 
                SPM[j][i] = SPM[i][j]; 
            } 
        } 
        return SPM; 
    } 
 
    public static void main(String[] args) { 
        /* ���㼯��V={v1,v2,������vn} */
        int[][] W = { { 0, 1, 2, 3 }, { 1, 0, 4, 5 }, { 2, 4, 0, 2 }, 
                { 3, 5, 2, 0 } }; 
        int[][] W1 = { { 0, 1, 4, -1, -1, -1 }, { 1, 0, 2, 7, 5, -1 }, 
                { 4, 2, 0, -1, 1, -1 }, { -1, 7, -1, 0, 3, 2 }, 
                { -1, 5, 1, 3, 0, 6 }, { -1, -1, -1, 2, 6, 0 } };// ����һ��Ȩֵ���� 
        int[][] D = getShortestPathMatrix(W); 
        //������Ľ�� 
//        int n = 4;
//        int[] min = new int[(n*n-n)/2];
        
        for (int i = 0; i < D.length; i++) { 
            for (int j = 0; j < D[i].length; j++) { 
                System.out.print(D[i][j] + " "); 
            } 
            System.out.println(); 
        }
    }
}