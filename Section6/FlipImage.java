import acm.graphics.*;

public class FlipImage {
	public GImage flipHorizontal(GImage image) {
		int[][] arr = image.getPixelArray();
		int m = arr.length, n = arr.length;
		for (int i = 0; i < m; ++i) {
			int start = 0, end = n - 1;
			while (start < end) {
				int tmp = arr[i][start];
				arr[i][start] = arr[i][end];
				arr[i][end] = tmp;
				++start;
				--end;
			}
		}
		
		return new GImage(arr);
	}
}