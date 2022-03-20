//拓扑排序
//int a[15][15];//储存关系
//int b[15];//储存入度
//int main()
//{
//	int x, y;
//	cin >> x >> y;//点和边数
//	while (y--)
//	{
//		int m, n;
//		cin >> m >> n;//相连两点
//		a[m][n] = 1;
//	}
//	for (int i = 1; i <= x; i++)
//	{
//		//计算入度
//		int k = 0;
//		for (int j = 1; j <= x; j++)
//		{
//			if (a[j][i] == 1)
//			{
//				k++;
//			}
//		}
//		b[i] = k;
//	}
//	//寻找入度为零的点 输出并删除他和与他相关的边
//	int z = 0;
//	while (1)
//	{
//		for (int i = 1; i <= x; i++)
//		{
//			if (b[i] == 0) {
//				cout << i << " ";
//				b[i] = -1;//删除点
//				z++;
//				for (int j = 1; j <= x; j++)
//				{
//					if (a[i][j] == 1)
//					{
//						b[j]--;//删除边
//					}
//				}
//			}
//		}
//		if (z == x)break;
//	}
//	return 0;
//}



//int n, m, l, r;
//int a[100010];
//bool sc(int x) {
//	int num = 0, t = 0;
//	for (int i = 0; i < n; i++) {
//		if (t + a[i] <= x)t += a[i];
//		else { t = a[i]; num++; }
//	}
//	return num >= m;
//}
//int main()
//{
//	cin >> n >> m;
//	for (int i = 0; i < n; i++) {
//		cin >> a[i];
//		l = max(l, a[i]);
//		r += a[i];
//	}
//	while (l <= r) {
//		int mid = (l + r) / 2;
//		if (sc(mid))l = mid + 1;
//		else r = mid - 1;
//	}
//	cout << l << endl;
//	return 0;
//}


//vector<int>a[5];
//int main() {
//	int n, m;
//	cin >> n >> m;
//	for (int i = 0; i < m; i++)
//	{
//		int f;
//		cin >> f;
//		if (f == 1) {
//			int l, r, k;
//			cin >> l >> r >> k;
//			a[i].push_back(l);
//			a[i].push_back(r);
//			a[i].push_back(k);
//			continue;
//		}
//		sort(a, a + i);
//
//	}
//	return 0;
//}
//

//kruskal算法  和prim算法  求最小生成树

//prim算法  如果忘记了请上blibli复习
//int b[100][100];
//bool c[100];
//int main() {
//	//memset(b, -1, sizeof(b));//memset初始化二维数组只能初始化为0或-1 否则为随机值
//	int n, m;
//	cin >> n >> m;
//	for (int i = 0; i < m; i++) {
//		int x, y, m;
//		cin >> x >> y >> m;
//		if (b[x][y]<m)
//		{
//			b[x][y] = m;
//			b[y][x] = m;
//		}
//	}
//	int flag = 1;
//	int ans = 0;
//	c[0] = 1;
//	while (flag) {
//		flag = 0;
//		int minn = 99999;
//		int dst;
//		for (int i = 0; i < n; i++) {
//			if (c[i]) {
//				for (int j = 0; j < n; j++) {
//					if (i == j)continue;
//					if (!c[j]) {
//						flag = 1;
//						if (b[i][j] && b[i][j]<minn) {
//							minn = b[i][j];
//							dst = j;
//						}
//					}
//				}
//			}
//		}
//		if (flag) {
//			ans += minn;
//			c[dst] = 1;
//		}
//	}
//	cout << ans << endl;
//	return 0;
//}
//测试用例
/*
9 14
0 1 4
0 7 8
1 7 11
1 2 8
7 6 1
7 8 7
2 8 2
6 8 6
2 3 7
5 6 2
2 5 4
3 5 14
3 4 9
5 4 10
*/


////kruskal算法
//struct node {
//	int x, y, w;
//};
//node a[200010];
//int b[5010];
//int find( int x)
//{
//	if (x == b[x])return x;
//	return b[x] = find(b[x]);
//}
//bool cmp(node x, node y) {
//	return x.w < y.w;
//}
//int main() {
//	int n, m;
//	cin >> n >> m;
//	for (int i = 0; i <= n; i++) {
//		b[i] = i;
//	}
//	for (int i = 0; i < m; i++) {
//		cin >> a[i].x >> a[i].y >> a[i].w;
//	}
//	sort(a, a + m, cmp);
//	int ans = 0;
//	int primnum = 0;
//	for (int i = 0;i < m; i++) {
//		int x, y, w;
//		x = a[i].x;
//		y = a[i].y;
//		w = a[i].w;
//		int fx = find(x);
//		int fy = find(y);
//		if (fx == fy)continue;
//		b[fx] = fy;
//		ans += w;
//		if (++primnum == n - 1)break;
//	}
//	if(primnum==n-1)
//		cout << ans << endl;
//	else cout << "orz" << endl;//代表图不连通
//	return 0;
//}



/*
#define _CRT_SECURE_NO_WARNINGS
#include<bits/stdc++.h>
using namespace std;
int a[200][200];
int b[200];
int main() {
int t;
cin >> t;
string s;
while (t--) {
memset(a, 0, sizeof(a));
memset(b, 0, sizeof(b));
cin >> s;
long long ans = 0;
int maxx = -1;
for (int i = 0; i < s.size(); i++) {
int x = s[i];
maxx = max(maxx, x);
for (int j = x; j <= maxx; j++) {
if (b[j] && !a[x][j]) {
a[x][j] = 1;
ans++;
}
}
b[x] = 1;
}
cout << ans << endl;
}
return 0;
}
*/

//密码
//int n;
//int ans = 0;
//void method(int i, int x) {//x 为xi的值
//	if (ans == 998244353)ans = 0;
//	if (i == n - 1) { ans++; return; }
//	if (x == 1) { method(i + 1, 1); method(i + 1, 2); return; }
//	if (x == 9) { method(i + 1, 8);  method(i + 1, 9); return; }
//	method(i + 1, x);
//	method(i + 1, x + 1);
//	method(i + 1, x - 1);
//	return;
//}
//int main() {
//	cin >> n;
//	for (int i = 1; i <= 9; i++) {
//		method(0, i);
//	}
//	cout << ans << endl;
//	return 0;
//}


//int main() {
//	vector<int>v;
//	v.push_back(1);
//	v.push_back(2);
//	v.push_back(3);
//	for (auto a : v) {//or(auto a:b)中b为一个容器，效果是利用a遍历并获得b容器中的每一个值，但是a无法影响到b容器中的元素。
//		cout << a << endl;//1 2 3 
//	}
//
//
//	int arr[5] = { 1,2,3,4,5 };
//	for (auto &a : arr)//for(auto &a:b)中加了引用符号，可以对容器中的内容进行赋值，即可通过对a赋值来做到容器b的内容填充。
//	{
//		a = 10;
//	}
//	for (auto a : arr)
//	{
//		cout << a << " ";//10 10 10 10 10
//	}
//	cout << endl;
//
//	return 0;
//}




//背包问题  即有一个背包的容积为j 共有i个物品 每个物品都有它的体积和价值 现从i个物品往背包中装入价值最大的物品（可以是多个）
/*
问题描述： 共有4个物品 编号为1到4 它的体积和价值为
编号： 1   2   3   4
体积： 2   3   4   5
价值： 3   4   5   6
请输出背包容积从0到8  从前0到4个物品中选择的最大价值
*/

//int f[15][15];
//int w[10];
//int v[10];
//int main() {
//	for (int i = 1; i <= 4; i++) {
//		cin >> w[i] >> v[i];
//	}
//	for (int i = 1; i <= 4; i++) {
//		for (int j = 1; j <= 8; j++) {
//			if (j - w[i] >= 0) {
//				f[i][j] = max(f[i - 1][j], f[i - 1][j - w[i]] + v[i]);
//			}
//			else f[i][j] = f[i - 1][j];
//		}
//	}
//	for (int i = 0; i <= 4; i++) {
//		for (int j = 0; j <= 8; j++) {
//			cout << f[i][j] << " ";
//		}
//		cout << endl;
//	}
//	/*
//	0 0 0 0 0 0 0 0 0
//	0 0 3 3 3 3 3 3 3
//	0 0 3 4 4 7 7 7 7
//	0 0 3 4 5 7 8 9 9
//	0 0 3 4 5 7 8 9 10
//	*/
//	return 0;
//}

//int w[110];
//bool f[110][200010];
//int main() {
//	int n;
//	cin >> n;
//	int m = 0;
//	for (int i = 1; i <= n; i++) {
//		cin >> w[i];
//		m += w[i];
//	}
//	f[0][100000] = 1;
//	int i;
//	for ( i = 1; i <= n; i++) {
//		for (int j = -m; j <= m; j++) {
//			f[i][j+100000] = f[i - 1][j + 100000];//代表不装该物品
//			//装一个+wi
//			if (j - w[i] >= -m)f[i][j + 100000] |= f[i - 1][j - w[i] + 100000];
//			//装一个-wi
//			if (j + w[i] <= m)f[i][j + 100000] |= f[i - 1][j + w[i] + 100000];
//		}
//	}
//	int ret = 0;
//	for (int j = 1; j <= m; j++) {
//		if (f[n][j+100000])ret++;
//	}
//	cout << ret << endl;
//	return 0;
//}






//int a[100010];
//long long b[100010];
//long long sum = 0;
//int main() {
//	int n, k;
//	cin >> n >> k;
//	for (int i = 1; i <= n; i++) {
//		cin >> a[i];
//	}
//	sort(a, a + n);
//	for (int i = 1; i <= n; i++) {
//		b[i] = b[i - 1] + a[i] * a[i];
//	}
//	long long summ = 0;
//	int sum = 0;
//	long long avg = b[n] / k;
//	int flag = 0;
//	int kk;
//	for (int i = n; i >= 0; i--) {
//		if (flag)break;
//		summ = b[n] - b[i];
//		if (summ < avg)continue;
//		kk = i;
//		for (int j = i - 1; j >= 1; j--) {
//			if (b[k] - b[j] >= summ) { sum++; kk = j - 1; }
//		}
//		if (sum <= k)flag = 1;
//	}
//	cout << summ << endl;
//	return 0;
//}




//int a[100010];
//struct node {
//	int key;
//	int value = 0;
//	bool cur;
//};
//vector<node>v;
//int iscmp(int x) {
//	for (int i = 0; i < v.size(); i++) {
//		if (v[i].key == x)return i;
//	}
//	return -1;
//}
//bool cmp(node x, node y) {
//	return x.value < y.value;
//}
//int main() {
//	int n, m;
//	cin >> n >> m;
//	int num = 0;
//	int ans = 0;
//	vector<node>::iterator it;
//	for (int i = 0; i < n; i++) {
//		int x;
//		cin >> x;
//		a[i] = x;
//		int index = iscmp(x);
//		if (index == -1) {
//			node n;
//			n.key = x;
//			n.value = 1;
//			n.cur = false;
//			v.push_back(n);
//		}
//		else {
//			v[index].value++;
//			v[index].cur = false;
//		}
//	}
//	for (int i = 0; i < n; i++) {
//		int x = a[i];
//		int index = iscmp(x);
//		v[index].value--;
//		if (!v[index].cur) {
//			ans++;
//			v[index].cur = true;
//			if (num < m) {
//				num++;
//			}
//			else {
//				sort(v.begin(), v.end(), cmp);
//				it = v.begin();
//				it->cur = false;
//			}
//		}
//	}
//	cout << ans << endl;
//	return 0;
//}




//vector<int>a[1000010];
//int b[1000010];
//bool c[1000010];
//long long sum = 0;
//int num = 0;
//int maxx = -1;
//void deal(int x) {
//	c[x] = 1;
//	num++;
//	maxx = max(maxx, b[x]);
//	for (int i = 0; i < a[x].size(); i++) {
//		if (!c[a[x][i]])deal(a[x][i]);
//	}
//}
//int main() {
//	int n, m;
//	cin >> n >> m;
//	for (int i = 1; i <= n; i++)cin >> b[i];
//	for (int i = 1; i <= m; i++) {
//		int x, y;
//		cin >> x >> y;
//		a[x].push_back(y);
//		a[y].push_back(x);
//	}
//	for (int i = 1; i <= n; i++) {
//		if (!c[i]) {
//			maxx = -1;
//			num = 0;
//			deal(i);
//			sum += num*maxx;
//		}
//	}
//	cout << sum << endl;
//	return 0;
//}




//运用二维数组的写法  比较浪费空间
//#define T 1010
//#define M 110
//int f[M][T];
//int w[M];
//int v[M];
//int main() {
//	int t, m;
//	cin >> t >> m;
//	for (int i =1;i<=m;i++)cin>>w[i]>>v[i];
//	for (int i = 1; i <= m; i++) {
//		for (int j = 0; j <= t; j++) {
//			f[i][j] = f[i - 1][j];
//			if (j - w[i] >= 0)f[i][j] = max(f[i][j], f[i - 1][j - w[i]] + v[i]);
//		}
//	}
//	cout << f[m][t] << endl;
//	return 0;
//}

//一维数组写法
//#define _CRT_SECURE_NO_WARNINGS
//#include <bits/stdc++.h>
//using namespace std;
//#define T 1010
//#define M 110
//int f[T];
//int w[M];
//int v[M];
//int main() {
//	int t, m;
//	cin >> t >> m;
//	for (int i = 1; i <= m; i++)cin >> w[i] >> v[i];
//	for (int i = 1; i <= m; i++) {
//		for (int j = t; j - w[i] >= 0; j--) {
//			f[j] = max(f[j], f[j - w[i]] + v[i]);//因为j从后往前遍历  f(j-w[i])在f(j)之前  所以在修改f(i,j)时f(j-w[i])相当于f(i-1)(j-w[i]);
//		}
//	}
//	cout << f[t] << endl;
//	return 0;
//}





//质数筛(计算1到1e8间的所有质数
//#define N (int)1e2
//bool a[N];
//int main() {
//	for (int i = 2; i < N; i++) {
//		if (!a[i]) {
//			cout << i << endl;
//			for (int j = 2; i*j < N; j++)a[i*j] = 1;
//		}
//	}
//	return 0;
//}



//#define N 110
//int f[N][N];
//int g[N][N];
//int s[N];
//int main() {
//	int n;
//	cin >> n;
//	for (int i = 1; i <= n; i++) cin >> s[i], s[i] += s[i - 1];
//	/*for (int i = 1; i <=n; i++) {
//		for (int j = n; j >=2; j--) {
//			f[i][j] = 99999999;
//			g[i][j] = -1;
//			for (int k = i ; k < j; k++) {
//				f[i][j] = min(f[i][j], f[i][k] + f[k + 1][j] + s[j] - s[i - 1]);
//				g[i][j] = max(f[i][j], f[i][k] + f[k + 1][j] + s[j] - s[i - 1]);
//			}
//		}
//	}*/
//
//	for (int len = 2; len <= n; len++) {
//		for (int i = 1; i + len - 1 <= n; i++) {
//			int j = i + len - 1;
//			f[i][j] = 9999999;
//			for (int k = i; k < j; k++) {
//				f[i][j] = min(f[i][j], f[i][k] + f[k + 1][j] + s[j] - s[i - 1]);
//				g[i][j] = max(g[i][j], g[i][k] + g[k + 1][j] + s[j] - s[i - 1]);
//
//			}
//
//		}
//	}
//	cout << f[1][n]-1 << endl;
//	cout << g[1][n] << endl;
//	return 0;
//}



//优先队列

//class cmp1 {
//public:
//	bool operator()(int x, int y) {
//		return x > y;
//	}
//};

//struct cmp1 {//上面那种种也行  不过operator函数要申明为public
//	bool operator()(int x, int y) {
//		return x > y;
//	}
//};
//
//struct cmp2 {
//	bool operator()(int x, int y) {
//		return x < y;
//	}
//};
//int  main(void) {
//
//
//	//   priority_queue< int > q;// 默认是 从大到小。 
//	//   priority_queue < int , vector<int> ,less<int> > q;//从大到小 
//	//   priority_queue < int , vector<int>, greater<int> > q; //从小到大，需要vector
//	//  priority_queue < int , vector<int> , cmp1  > q;//从大到小，需要vector
//	//   priority_queue < int , vector<int> , cmp  > q;//从小到大，需要vector
//	//priority_queue<int>q;//3 2 1
//	//priority_queue<int, vector<int>, less<int>>q;//3 2 1
//	//priority_queue<int, vector<int>, greater<int>>q;//1 2 3
//	//priority_queue<int, vector<int>, cmp1>q;//1 2 3
//	//priority_queue<int, vector<int>, cmp2>q;//3 2 1
//	/*q.push(1);
//	q.push(2);
//	q.push(3);*/
//
//	while (!q.empty()) {
//		int t = q.top();
//		q.pop();
//		printf("%d ", t);
//
//	}
//	cout << endl;
//	return 0;
//}
//class student {
//public:
//	int age;
//	string name;
//	student(string name, int age) {
//		this->age = age;
//		this->name = name;
//	}
//};
//class cmp {
//public:
//	bool operator()(student s1, student s2) {
//		return s1.age > s2.age;
//	}
//};
//int main() {
//	student s1("zhangsan", 17);
//	student s2("lisi", 16);
//	student s3("wangwu", 19);
//	priority_queue<student, vector<student>, cmp>q;
//	q.push(s1);
//	q.push(s2);
//	q.push(s3);
//	while (!q.empty()) {
//		student s = q.top();
//		cout << s.age << " " << s.name << endl;
//		q.pop();
//	}
//	return 0;
//}


/*
#define N 5010
long long f[N][N];
long long g[N][N];
bool ll[N];
bool rr[N];
int main() {
int n, m;
scanf("%d%d", &n, &m);
while (m--) {
int l, r;
scanf("%d%d", &l, &r);
ll[l] = 1;//ll[i]为false 则i不会被吃
rr[r] = 1;//rr[i]为false 则i不会吃其他动物
f[l][r]++;
g[l][r]++;
}
for (int len = 2; len <= n; len++) {
for (int i = 1; i + len - 1 <= n; i++) {
int j = i + len - 1;
for (int k = 1; k <= n; k++) {
f[i][j]  += g[i][k] * f[k][j];
}
for (int k = n; k >=1; k--) {
f[j][i] += g[j][k] * f[k][i];
}
}
}
long long ans = 0;
for (int i = 1; i <= n; i++) {
if (!rr[i]) {
for (int j = 1; j <= n; j++) {
if (!ll[j])ans += f[i][j];
}
}
}
cout << ans % 80112002 << endl;
return 0;
}
/*
7 9
4 1
4 2
4 3
5 1
5 3
3 2
1 6
2 6
3 7
*/
//*/

//辗转相除法求最大公约数
/*
//原理
有一根绳子长度为77
------------------------------------
另一根绳子长度为28
------------
可以发现 77 由两个28和一个21组成
如果要找到一个数既可被77整除 又可被21整除  那么就要找到一个整数 既可以被28整除 又可以被21整除
依次类推 直到 需要寻找的两个值之间就可以整除  这个数就是最小公约数
*/
//代码实现
//int gcd(int x, int y) {
//	return y ? gcd(y, x%y) : x;
//}
//int main() {
//	int ret = gcd(1000, 100);
//	cout << ret << endl;
//	return 0;
//}



//在求最大公约数的基础上求最小公倍数
/*
分析
假设 :
a=m*k
b=n*k  其中k为a,b的最大公约数
那么 m,n的最大公约数必然是m*n
那么 a,b的最小公倍数为m*n*k(也可以用绳子来想象)
那么 a,b的最小公倍数为 a*b/k
*/
//代码实现
//int gcd(int x, int y) {
//	return y ? gcd(y, x%y) : x;
//}
//int gbs(int x, int y) {
//	return x*y / gcd(x, y);
//}
//int main() {
//	int ret = gbs(24, 36);
//	cout << ret << endl;//72
//	ret = gbs(35, 75);
//	cout << ret << endl;//525
//	return 0;
//}


//acwing4310

//int n, q;
//#define N (int)2e5+10
//vector<int>g[N];
//int pp[N], qq[N], top, sz[N];
//void dfs(int u) {
//	sz[u] = 1;//首先将自己算进去
//	qq[++top] = u;
//	pp[u] = top;
//	for (auto v : g[u])dfs(v), sz[u] += sz[v];
//}
//int main() {
//	scanf("%d%d", &n, &q);
//	for (int i = 2; i <= n; i++) {
//		int t;
//		scanf("%d", &t);
//		g[t].push_back(i);
//	}
//	dfs(1);
//	while (q--) {
//		int u, k;
//		scanf("%d%d", &u, &k);
//		if (k > sz[u])printf("-1\n");
//		else printf("%d\n", qq[pp[u] + k - 1]);
//	}
//	return 0;
//}



//#define N (int)1e5+10
//int n, l;
//int q[N];
//int main() {
//	cin >> n >> l;
//	for (int i = 1; i <= n; i++)cin >> q[i];
//	sort(q + 1, q + n + 1, greater<int>());
//	int res = 0;
//	for (int i = 1, j = n; i <= n; i++) {
//		while (j&&q[j] < i)j--;//双指针 数组从大到小
//		if (q[i] >= i - 1 && i - j <= l)res = i;
//	}
//	cout << res << endl;
//	return 0;
//}


/*
#define ll long long  这两种都行
typedef long long lll;
ll m;
lll n;
int main() {
m = 10;
cout << m << endl;
return 0;
}
*/