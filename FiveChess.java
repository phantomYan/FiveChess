import java.util.Scanner;

public class FiveChess {
	// 主程序
	public static void main(String[] args) {
		// 先建棋盘
		Boolean end = true;
		char[][] arr = new char[16][16];
		// 将字母翻译成数字
		char[] h = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
				'b', 'c', 'd', 'e', 'f' };
		// 数组编号
		int i1 = 20, i2 = 20;
		// 棋盘数组
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = '*';
			}
		}
		while (end) {
			// 打印棋盘
			pp(arr);
			// 下白子
			// bf(arr,h,i1,i2,end);
			end = bf(arr, h, i1, i2, end);
			//			
//			System.out.println("1:" + end);
			// 再次打印棋盘
			if (end == true) {
				pp(arr);
				// 黑方落子
				// hf(arr,h,i3,i4,end);
				end = hf(arr, h, i1, i2, end);
			}
		}
		// 最后打印棋盘
		pp(arr);
	}

	// 画棋盘
	public static void pp(char[][] arr) {
		// 打印棋盘
		// 第一行
		System.out.print("  0 1 2 3 4 5 6 7 8 9 a b c d e f");
		for (int i = 0; i < arr.length; i++) {
			// 换行
			System.out.println();
			// 竖排第一行
			if (i <= 9) {
				System.out.print(i + " ");
			} else if (i == 10) {
				System.out.print("a ");
			} else if (i == 11) {
				System.out.print("b ");
			} else if (i == 12) {
				System.out.print("c ");
			} else if (i == 13) {
				System.out.print("d ");
			} else if (i == 14) {
				System.out.print("e ");
			} else if (i == 15) {
				System.out.print("f ");
			}
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
		}
		System.out.println("");
	}

	// 白方落子
	public static Boolean bf(char[][] arr, char[] h, int i1, int i2, Boolean end) {
		// 白方落子
		int re = 0;
		while (re == 0) {
			System.out.println("请白方落子：");
			Scanner sc = new Scanner(System.in);
			String str = sc.next();
			char c1 = str.charAt(0);
			char c2 = str.charAt(1);

			for (int i = 0; i < h.length; i++) {
				if (c1 == h[i]) {
					i1 = i;
				}
				if (c2 == h[i]) {
					i2 = i;
				}
			}
			// 判断输入是否非法
			if (i1 == 20) {
				System.out.println("第一个位置非法");
			} else if (i2 == 20) {
				System.out.println("第二个位置非法");
			} else if (arr[i1][i2] == '@' || arr[i1][i2] == 'O') {
				System.out.println("已有棋子");
			} else {
				arr[i1][i2] = 'O';
				re = 1;
			}
		}
		return vt(arr, i1, i2, "白", 'O', end);
	}

	// 黑方落子
	public static Boolean hf(char[][] arr, char[] h, int i3, int i4, Boolean end) {

		int re = 0;
		while (re == 0) {
			// 黑方落子

			System.out.println("请黑方落子：");
			// 获取下子的位置
			Scanner sc = new Scanner(System.in);
			String str2 = sc.next();
			char c3 = str2.charAt(0);
			char c4 = str2.charAt(1);

			for (int i = 0; i < h.length; i++) {
				if (c3 == h[i]) {
					i3 = i;
				}
				if (c4 == h[i]) {
					i4 = i;
				}
			}
			// 判断输入是否非法
			if (i3 == 20) {
				System.out.println("第一个位置非法");
			} else if (i4 == 20) {
				System.out.println("第二个位置非法");
			} else if (arr[i3][i4] == 'O' || arr[i3][i4] == '@') {
				System.out.println("已有棋子");
			} else {
				// System.out.println(i3+"ss"+i4);
				arr[i3][i4] = '@';
				re = 1;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 'O') {

				}

			}
		}
		return vt(arr, i3, i4, "黑", '@', end);
	}

	// 获胜判断
	public static Boolean vt(char[][] arr, int i1, int i2, String s, char x,
			Boolean end) {
		int o = 1, u = 1;
		// 竖向
		while (i1 - o >= 0 && arr[i1 - o][i2] == x) {
			o++;
		}
		if (o < 5) {
			while (i1 - o + u < 16 && arr[i1 - o + u][i2] == x) {
				u++;
			}
			if (u > 5) {
				System.out.println(s + "子获胜1");
				end = false;
			}
		} else if (o >= 5) {
			System.out.println(s + "子获胜2");
			end = false;
		}
		o = 1;
		u = 1;
		// 横向
		while (i2 - o >= 0 && arr[i1][i2 - o] == x) {
			o++;
		}
		if (o < 5) {
			while (i2 - o + u < 16 && arr[i1][i2 - o + u] == x) {
				u++;
			}
			if (u > 5) {
				System.out.println(s + "子获胜3");
				end = false;
			}
		} else if (o >= 5) {
			System.out.println(s + "子获胜4");
			end = false;
		}
		o = 1;
		u = 1;
		// 斜线
		while (i1 + o < 16 && i2 - o >= 0 && arr[i1 + o][i2 - o] == x) {
			o++;
		}
		if (o < 5) {
			while (i1 + o - u >= 0 && i2 - o + u < 16
					&& arr[i1 + o - u][i2 - o + u] == x) {
				u++;
			}
			if (u > 5) {
				System.out.println(s + "子获胜5");
				end = false;
			}
		} else if (o >= 5) {
			System.out.println(s + "子获胜6");
			end = false;
		}
		o = 1;
		u = 1;
		// 斜线2
		while (i1 + o < 16 && i2 + o < 16 && arr[i1 + o][i2 + o] == x) {
			o++;
		}
		if (o < 5) {
			while (i1 + o - u >= 0 && i2 + o - u >= 0
					&& arr[i1 + o - u][i2 + o - u] == x) {
				u++;
			}
			if (u > 5) {
				System.out.println(s + "子获胜7");
				end = false;
				System.out.println(u);
			}
		} else if (o >= 5) {
			System.out.println(s + "子获胜8");
			end = false;
		}
//		System.out.println("--" + end);
		return end;
	}
}
