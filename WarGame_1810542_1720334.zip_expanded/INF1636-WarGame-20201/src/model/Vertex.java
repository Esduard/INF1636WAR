package model;

import java.awt.Point;
import java.util.List;

@SuppressWarnings("serial")
class Vertex extends Point {

	public Vertex(int x, int y) {
		super(x, y);
	}

	public static boolean isInsidePolygon(int vertexCount, List<Vertex> polygon, float x, float y) {
		int i, j;
		boolean c = false;
		for (i = 0, j = vertexCount - 1; i < vertexCount; j = i++) {
			if (((polygon.get(i).y > y) != (polygon.get(j).y > y))
				&& (x < (polygon.get(j).x - polygon.get(i).x) * (y - polygon.get(i).y) / (polygon.get(j).y - polygon.get(i).y) + polygon.get(i).x))
				c = !c;
		}
		return c;
	}
}
