import java.util.Scanner;

public class FiveChess {
	// ������
	public static void main(String[] args) {
		// �Ƚ�����
		Boolean end = true;
		char[][] arr = new char[16][16];
		// ����ĸ���������
		char[] h = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
				'b', 'c', 'd', 'e', 'f' };
		// ������
		int i1 = 20, i2 = 20;
		// ��������
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = '*';
			}
		}
		while (end) {
			// ��ӡ����
			pp(arr);
			// �°���
			// bf(arr,h,i1,i2,end);
			end = bf(arr, h, i1, i2, end);
			//			
//			System.out.println("1:" + end);
			// �ٴδ�ӡ����
			if (end == true) {
				pp(arr);
				// �ڷ�����
				// hf(arr,h,i3,i4,end);
				end = hf(arr, h, i1, i2, end);
			}
		}
		// ����ӡ����
		pp(arr);
	}

	// ������
	public static void pp(char[][] arr) {
		// ��ӡ����
		// ��һ��
		System.out.print("  0 1 2 3 4 5 6 7 8 9 a b c d e f");
		for (int i = 0; i < arr.length; i++) {
			// ����
			System.out.println();
			// ���ŵ�һ��
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

	// �׷�����
	public static Boolean bf(char[][] arr, char[] h, int i1, int i2, Boolean end) {
		// �׷�����
		int re = 0;
		while (re == 0) {
			System.out.println("��׷����ӣ�");
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
			// �ж������Ƿ�Ƿ�
			if (i1 == 20) {
				System.out.println("��һ��λ�÷Ƿ�");
			} else if (i2 == 20) {
				System.out.println("�ڶ���λ�÷Ƿ�");
			} else if (arr[i1][i2] == '@' || arr[i1][i2] == 'O') {
				System.out.println("��������");
			} else {
				arr[i1][i2] = 'O';
				re = 1;
			}
		}
		return vt(arr, i1, i2, "��", 'O', end);
	}

	// �ڷ�����
	public static Boolean hf(char[][] arr, char[] h, int i3, int i4, Boolean end) {

		int re = 0;
		while (re == 0) {
			// �ڷ�����

			System.out.println("��ڷ����ӣ�");
			// ��ȡ���ӵ�λ��
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
			// �ж������Ƿ�Ƿ�
			if (i3 == 20) {
				System.out.println("��һ��λ�÷Ƿ�");
			} else if (i4 == 20) {
				System.out.println("�ڶ���λ�÷Ƿ�");
			} else if (arr[i3][i4] == 'O' || arr[i3][i4] == '@') {
				System.out.println("��������");
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
		return vt(arr, i3, i4, "��", '@', end);
	}

	// ��ʤ�ж�
	public static Boolean vt(char[][] arr, int i1, int i2, String s, char x,
			Boolean end) {
		int o = 1, u = 1;
		// ����
		while (i1 - o >= 0 && arr[i1 - o][i2] == x) {
			o++;
		}
		if (o < 5) {
			while (i1 - o + u < 16 && arr[i1 - o + u][i2] == x) {
				u++;
			}
			if (u > 5) {
				System.out.println(s + "�ӻ�ʤ1");
				end = false;
			}
		} else if (o >= 5) {
			System.out.println(s + "�ӻ�ʤ2");
			end = false;
		}
		o = 1;
		u = 1;
		// ����
		while (i2 - o >= 0 && arr[i1][i2 - o] == x) {
			o++;
		}
		if (o < 5) {
			while (i2 - o + u < 16 && arr[i1][i2 - o + u] == x) {
				u++;
			}
			if (u > 5) {
				System.out.println(s + "�ӻ�ʤ3");
				end = false;
			}
		} else if (o >= 5) {
			System.out.println(s + "�ӻ�ʤ4");
			end = false;
		}
		o = 1;
		u = 1;
		// б��
		while (i1 + o < 16 && i2 - o >= 0 && arr[i1 + o][i2 - o] == x) {
			o++;
		}
		if (o < 5) {
			while (i1 + o - u >= 0 && i2 - o + u < 16
					&& arr[i1 + o - u][i2 - o + u] == x) {
				u++;
			}
			if (u > 5) {
				System.out.println(s + "�ӻ�ʤ5");
				end = false;
			}
		} else if (o >= 5) {
			System.out.println(s + "�ӻ�ʤ6");
			end = false;
		}
		o = 1;
		u = 1;
		// б��2
		while (i1 + o < 16 && i2 + o < 16 && arr[i1 + o][i2 + o] == x) {
			o++;
		}
		if (o < 5) {
			while (i1 + o - u >= 0 && i2 + o - u >= 0
					&& arr[i1 + o - u][i2 + o - u] == x) {
				u++;
			}
			if (u > 5) {
				System.out.println(s + "�ӻ�ʤ7");
				end = false;
				System.out.println(u);
			}
		} else if (o >= 5) {
			System.out.println(s + "�ӻ�ʤ8");
			end = false;
		}
//		System.out.println("--" + end);
		return end;
	}
}
