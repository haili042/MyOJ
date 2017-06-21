package com.haili.baidu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 
 * ���й滮���� סլ�����ֳ� n * m ������, ���ĳ�����������з��ݵ�һ����, ��ȡֵΪ1, �յ�ȡֵΪ0, ��ֵΪ 1
 * �����ڵ�Ԫ����ɵĳ�Ϊһ����������, ע��: �Խ��߷��õ�ֵΪ1 �ĵ�Ԫ����Ϊͬһ�� ��������(��2��)
 * 
 * �涨 'Ư��סլ' �ǵ����������ܶ��ǿյ�(�����Խ���)
 * 
 * 
 * ����������סլ�ĸ���
 * 
 * case input > { { 0, 1, 0, 0, 0 }, { 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0,
 * 0, 1, 1, 1 }, { 0, 0, 0, 0, 0 } } > { { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0,
 * 1, 0 }, { 0, 0, 0, 0 } }
 * 
 * output > 2 > 0
 * 
 * 
 * */

public class T1 {
	List<List<Pos>> buildings;
	int[][] grid;
	int n;
	int m;

	public T1(int[][] grid) {
		this.grid = grid;
		n = grid.length;
		m = grid[0].length;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 0, 0, 0 }, { 0, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 1 }, { 0, 0, 0, 0, 0 } };

		int[][] grid2 = { { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 },
				{ 0, 0, 0, 0 } };

		int[][] grid3 = { { 1, 0, 0, 1 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 },
				{ 0, 0, 0, 0 } };

		T1 t = new T1(grid);
		T1 t2 = new T1(grid2);
		T1 t3 = new T1(grid3);
		System.out.println(t.t1());
		System.out.println(t2.t1());
		System.out.println(t3.t1());

	}

	public int t1() {

		List<Pos> posList = new ArrayList<>();
		buildings = new ArrayList<>();

		// find 1
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					posList.add(new Pos(i, j));
				}
			}
		}

		// find buildings
		for (Pos p : posList) {
			boolean flag = true;
			List<Integer> indexs = new ArrayList<>();

			for (int i = 0; i < buildings.size(); i++) {
				List<Pos> list = buildings.get(i);
				for (Pos pp : list) {
					if (p.isJoin(pp)) {
						indexs.add(i);
						flag = false;
					}
				}
			}
			if (flag) {
				List<Pos> ll = new ArrayList<>();
				ll.add(p);
				buildings.add(ll);
			} else {

				int frist = indexs.get(0);
				indexs.remove(0);
				buildings.get(frist).add(p);
				for (int i = 0; i < indexs.size(); i++) {
					buildings.get(frist).addAll(buildings.get(indexs.get(i)));
				}
				for (int i = 0; i < indexs.size(); i++) {
					int ii = indexs.get(i);
					buildings.remove(ii);
				}

			}

		}
		System.out.println(buildings.toString());

		int res = 0;

		for (List<Pos> list : buildings) {
			boolean flag = true;
			for (Pos p : list) {
				flag &= check(list, p.x, p.y);
			}
			if (flag) {
				res++;
			}
		}

		return res;
	}

	public boolean check(List<Pos> building, int i, int j) {
		for (int upi = -1; upi <= 1; upi++) {
			for (int upj = -1; upj <= 1; upj++) {
				if (upi != 0 || upj != 0) {
					int ii = i + upi;
					int jj = j + upj;

					if (ii < 0 || jj < 0 || ii >= n || jj >= m) {
						continue;
					}

					if (!inBuilding(building, ii, jj) && grid[ii][jj] == 1) {
						return false;
					}
				}
			}

		}
		return true;
	}

	public boolean inBuilding(List<Pos> building, int i, int j) {
		for (Pos p : building) {
			if (p.equal(i, j)) {
				return true;
			}
		}
		return false;
	}

}

class Pos {
	int x;
	int y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// �ж��Ƿ����
	public boolean equal(int x, int y) {
		if (this.x == x && this.y == y) {
			return true;
		}
		return false;
	}

	// �ж��Ƿ�����
	public boolean isJoin(Pos pos) {
		if (this.x == pos.x && Math.abs(this.y - pos.y) == 1 || this.y == pos.y
				&& Math.abs(this.x - pos.x) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Pos [x=" + x + ", y=" + y + "]";
	}

}
