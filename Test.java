package javatest;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.AllPermission;
import java.util.*;//代表导入util中的所有方法 用“*”代表所有
/*
Map集合的概述和特点
Interface Map<k,v> k:键的类型 v:值的类型
将键值映射到对象 一个键值只能映射到一个值
Map是一个接口，所以我们采用多态来创建对象 HashMap
 */
//public class Test {
//    public static void main(String[] args) {
//        Map<Integer,String>map=new HashMap<>();
//        map.put(1,"张三");
//        map.put(2,"李四");
//        map.put(3,"王五");
//        System.out.println(map);//{1=张三, 2=李四, 3=王五}
//        map.put(3,"王二");
//        System.out.println(map);//{1=张三, 2=李四, 3=王二} 键值相同 等同于修改
//    }
//}
/*
Map集合的基本功能
V put(K key,V value);添加元素
V remove(Object key);删除元素
void clear();清空集合
boolean containsKey(Object key);判断是否存在key键
bolean containsValue(Object value);判断是否存在value
boolean isEmpty();判断集合是否为空
int size();求出集合长度
 */
//public class Test {
//    public static void main(String[] args) {
//        Map<Integer,String>map=new HashMap<>();
//        System.out.println(map.put(1,"zhangsan"));//null
//        System.out.println(map);//1=zhangsan
//        System.out.println(map.put(2,"lisi"));//null
//      //  System.out.println(map.remove(1));//zhangsan
//        System.out.println(map.put(1,"wangwei"));//zhangsan 所以说如果是修改原有的值 则会返回被修改的值
//        //其余功能不予展示  挺简单的
//
//    }
//}

/*
Map集合中的获取功能
V get(Object key);//根据键值找value
Set<K>keySet();//获取集合中所有键的集合
Collection<V>values();//获取集合中的所有值的集合
 */

//public class Test {
//    public static void main(String[] args) {
//        Map<Integer,String>map=new HashMap<>();
//        map.put(1,"张三");
//        map.put(2,"李四");
//        map.put(3,"王五");
//        System.out.println(map.get(1));//张三
//        Set<Integer> set = map.keySet();
//        for(Integer i:set){
//            System.out.println(i);//1 2 3
//        }
//        Collection<String> value = map.values();
//        for(String s:value){
//            System.out.println(s);//张三  李四 王五
//        }
//    }
//}

//Map集合的遍历 (方法一)
//public class Test {
//    public static void main(String[] args) {
//        Map<Integer,String>map=new HashMap<>();
//        map.put(1,"张三");
//        map.put(2,"李四");
//        map.put(3,"王五");
//        Set<Integer> set = map.keySet();
//        for(Integer i:set){
//            String s = map.get(i);
//            System.out.println(i+" "+s);
//            /*
//            1 张三
//            2 李四
//            3 王五
//             */
//        }
//    }
//}

//Map集合的遍历 方法二
//public class Test {
//    public static void main(String[] args) {
//        Map<Integer,String>map=new HashMap<>();
//        map.put(1,"张三");
//        map.put(2,"李四");
//        map.put(3,"王五");
//        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
//        for(Map.Entry<Integer, String> ma:entrySet){
//            Integer i=ma.getKey();
//            String s=ma.getValue();
//            System.out.println(i+" "+s);
//            /*
//            1 张三
//            2 李四
//            3 王五
//
//             */
//        }
//    }
//}

//案例展示：定义一个学生类 学生类作为key 学生居住地址作为value 创建Map集合 且保证集合中没有重复对象
//class student{
//    private String name;
//    private int age;
//
//    public student(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public student() {
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        student student = (student) o;
//
//        if (age != student.age) return false;
//        return name != null ? name.equals(student.name) : student.name == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + age;
//        return result;
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Map<student,String>map=new HashMap<>();
//        student s1=new student("张三",20);
//        student s2=new student("李四",21);
//        student s3=new student("王五",22);
//        student s4=new student("王五",22);
//
//        map.put(s1,"西安");
//        map.put(s2,"北京");
//        map.put(s3,"南昌");
//        map.put(s4,"上海");
//        Set<student> set = map.keySet();
//        for(student s:set){
//            String ss=map.get(s);
//           // System.out.println(s.getName()+","+s.getAge()+","+ss);//没重写Hashcode和equals之前
//            /*
//            王五,22,上海
//            李四,21,北京
//            张三,20,西安
//            王五,22,南昌
//             */
//
//            System.out.println(s.getName()+","+s.getAge()+","+ss);//没重写Hashcode和equals之后
//            /*
//            张三,20,西安
//            李四,21,北京
//            王五,22,上海
//             */
//        }
//    }
//}


//统计字符串中每个字符出现的次数
//输入一个字符串：如 aaabbbddd 输出：a(3)b(3)d(d)
//public class Test {
//    public static void main(String[] args) {
//        HashMap<Character, Integer> hm = new HashMap<>();
//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
//        for (int i = 0; i < line.length(); i++) {
//            char c = line.charAt(i);
//            Integer integer = hm.get(c);
//            if (integer == null) {
//                hm.put(c, 1);
//            } else {
//                integer++;
//                hm.put(c, integer);
//            }
//        }
//        StringBuilder sb=new StringBuilder();
//        Set<Character> set = hm.keySet();
//        for(Character cc:set){
//            Integer ii = hm.get(cc);
//            sb.append(cc).append("(").append(ii).append(")");
//        }
//        String ss = sb.toString();
//        System.out.println(ss);
//    }
//    /*
//    输入：aaadddccc
//    输出：a(3)c(3)d(3)//因为是HashMap所以无序  如果要有序  可以用TreeMap
//     */
//}

//Collections工具类
/*
void sort();将指定列表升序排序
void reverse();将指定列表反转
void shuffle();将指定列表随机排序  shuffle:v.坐立不安 打乱顺序 搪塞  n.洗牌 变换位置
 */

//public class Test {
//    public static void main(String[] args) {
//        List<Integer>list=new ArrayList<>();
//        list.add(10);
//        list.add(30);
//        list.add(40);
//        list.add(20);
//        list.add(50);
//       // System.out.println(list);//[10, 30, 40, 20, 50]
////        Collections.sort(list);
////        System.out.println(list);//[10, 20, 30, 40, 50]
////        Collections.reverse(list);
////        System.out.println(list);//[50, 20, 40, 30, 10]
//        Collections.shuffle(list);
//        System.out.println(list);//[10, 30, 20, 40, 50] 没有顺序 每次执行的结果都不一样
//    }
//}

//ArrayList集合存储学生对象并排序
//class student implements Comparable{
//    private String name;
//    private int age;
//
//    public student(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public student() {
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    @Override
//    public int compareTo(Object o) {
//        student s=(student) o;
//        int num=this.getAge()-s.getAge();
//        int num2=num==0?this.getName().compareTo(s.getName()):num;
//        return num2;
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        ArrayList<student>arrays=new ArrayList<>();
//        student s1=new student("zhangsan",20);
//        student s2=new student("lisi",19);
//        student s3=new student("wangwu",19);
//        student s4=new student("wanger",22);
//        arrays.add(s1);
//        arrays.add(s2);
//        arrays.add(s3);
//        arrays.add(s4);
//        Collections.sort(arrays);//要实现对自定义类型的排序  可以让student类实现Comparator接口 或使用匿名对象写comparator
//        for(student s:arrays){
//            System.out.println(s.getName()+" "+s.getAge());
//        }
//    }
//}

//模拟斗地主（洗牌  发牌）

//public class Test {
//    public static void main(String[] args) {
//        ArrayList<String>array=new ArrayList<>();
//        String[] colors={"♦","♣","♥","♠"};
//        String[] numbers={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
//        for(String s:colors){
//            for(String ss:numbers){
//                array.add(s+ss);
//            }
//        }
//        array.add("大王");
//        array.add("小王");
//        //System.out.println(array);
//        Collections.shuffle(array);
//        ArrayList<String>lqx=new ArrayList<>();
//        ArrayList<String>zmy=new ArrayList<>();
//        ArrayList<String>fqy=new ArrayList<>();
//        ArrayList<String>dp=new ArrayList<>();//底牌
//        for(int i=0;i<array.size();i++){
//            String poker=array.get(i);
//            if(i>=array.size()-3)dp.add(poker);
//            else if(i%3==0)lqx.add(poker);
//            else if(i%3==1)zmy.add(poker);
//            else if(i%3==2)fqy.add(poker);
//        }
//        showpoker("林青霞",lqx);
//        showpoker("张曼玉",zmy);
//        showpoker("风清扬",fqy);
//        showpoker("底牌",dp);
//
//
//    }
//    public static void showpoker(String name,ArrayList<String>p){
//        System.out.println(name+"的牌是：");
//        for(String s:p){
//            System.out.print(s+" ");
//        }
//        System.out.println();
//    }
//}

//模拟斗地主升级版（可将牌排序）
//public class Test {
//    public static void main(String[] args) {
//        HashMap<Integer, String> hm = new HashMap<>();
//        ArrayList<Integer> id = new ArrayList<>();
//        String[] color = {"♦", "♠", "♥", "♣"};
//        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
//        int index = 0;
//        for (String nb : number) {
//            for (String cl : color) {
//                hm.put(index, cl + nb);
//                id.add(index++);
//            }
//        }
//        hm.put(index, "小王");
//        id.add(index++);
//        hm.put(index, "大王");
//        id.add(index);
//        TreeSet<Integer> lqx = new TreeSet<>();
//        TreeSet<Integer> ly = new TreeSet<>();
//        TreeSet<Integer> fqy = new TreeSet<>();
//        TreeSet<Integer> dp = new TreeSet<>();
//        Collections.shuffle(id);//只能排list类型
//        for (int i = 0; i < id.size(); i++) {
//            int x = id.get(i);
//            if (i >= id.size() - 3) dp.add(x);
//            else if (i % 3 == 0) lqx.add(x);
//            else if (i % 3 == 1) ly.add(x);
//            else if (i % 3 == 2) fqy.add(x);
//        }
//        showpoker("林青霞", lqx, hm);
//        showpoker("柳岩", ly, hm);
//        showpoker("风清扬", fqy, hm);
//        showpoker("底牌", dp, hm);
//
//    }
//
//    public static void showpoker(String name, TreeSet<Integer> tss, HashMap<Integer, String> hmm) {
//        System.out.print(name + "的牌是：");
//        for (int i : tss) {
//            String poker = hmm.get(i);
//            System.out.print(poker + " ");
//        }
//        System.out.println();
//    }
//}

//file的概述和方法
/*
构造方法：
File(String pathname);//直接指定路径名来指向该文件
File(String parent,String child);//从父路径到子路径名来指向
File(File parent,String chile);//从父文件指向
// */
//public class Test {
//    public static void main(String[] args) {
//        File f1=new File("D:\\java");
//        System.out.println(f1);
//        File f2=new File("D:","java");
//        System.out.println(f2);
//        File f3=new File("D:");
//        File f4=new File(f3,"java");
//        System.out.println(f4);
//        /*
//        D:\java
//        D:java
//        D:java
//         */
//    }
//}

//File类的创建功能
/*
public boolean createNewFile();//创建文件  当该文件不存在时 创建该文件 并返回true
当该文件存在时 不创建该文件 false
public boolean mkdir();//创建目录  当该目录不存在时 创建该目录 并返回true
当该目录存在时 不创建该目录 false
public boolean mkdirs();//可以创建多级目录 当该多级目录不存在时 创建该多级目录 并返回true
当该多级目录存在时 不创建该多级目录 false
 */
//public class Test {
//    public static void main(String[] args) throws IOException {
//        File f1=new File("D://test//test.txt");
//        System.out.println(f1.createNewFile());//true
//
//        File f2=new File("D://test//tt");//true
//        System.out.println(f2.mkdir());
//
//        File f3=new File("D://Test//ttt//tttt");//Test和test效果相同 不严格区分大小写
//        //System.out.println(f2.mkdir());//false mkdirs不可创建多级目录
//        System.out.println(f3.mkdirs());
//
//        File f4=new File("D://test//123.txt");
//        System.out.println(f4.mkdir());//true  但创建的不是txt文件 而是一个名为123.txt的目录
//        //所以  最终创建的文件类型由调用的方法决定
//    }
//}


/*
File类的判断和获取功能
public boolean idDirectory();//测试路径名表示的File是否为目录
public boolean idFile();//测试路径名表示的File是否为文件
public boolean exists();//测试路径名表示的File是否存在
public String getAbsolutepath();//返回此路径名的绝对路径字符串
public String getpath();//将抽象路径名转换为字符串
public String getName();//返回此路径名表示的文件或者目录名称
public String[] list();//返回此路径名的目录中的所有目录和文件名称的字符串数组
public File[] listFiles();//返回此路径名的目录中的所有目录和文件名称的字符串数组
 */


//public class Test {
//    public static void main(String[] args) {
////        public boolean idDirectory();//测试路径名表示的File是否为目录
////        public boolean idFile();//测试路径名表示的File是否为文件
////        public boolean exists();//测试路径名表示的File是否存在
//        File f1=new File("D://test//test.txt");
//        System.out.println(f1.isDirectory());//false
//        System.out.println(f1.isFile());//true
//        System.out.println(f1.exists());//true
////        public String getAbsolutepath();//返回此路径名的绝对路径字符串
////        public String getpath();//将抽象路径名转换为字符串
////        public String getName();//返回此路径名表示的文件或者目录名称
//        File f2=new File("D://test//test.txt");
//        File file = f2.getAbsoluteFile();
//        System.out.println(file);//D:\test\test.txt
//        String path = f2.getPath();
//        System.out.println(path);//D:\test\test.txt
//        String name = f2.getName();
//        System.out.println(name);//test.txt
//        System.out.println("1111111111111111111111111111");//分隔
////        public String[] list();//返回此路径名的目录中的所有目录和文件名称的字符串数组
////        public File[] listFiles();//返回此路径名的目录中的所有目录和文件名称的字符串数组
//        File f3=new File("D://test");
//        String[] list = f3.list();
//        for(String ss:list){
//            System.out.println(ss);
//            /*
//            test文件中的文件或者目录：
//            123.txt
//            test.txt
//            tt
//            ttt
//             */
//        }
//        File[] files = f3.listFiles();
//        for(File ff:files){
//            //System.out.println(ff);
//
//            /*
//            D:\test\123.txt
//            D:\test\test.txt
//            D:\test\tt
//            D:\test\ttt  绝对路径
//             */
//            //如果只打印其中的文件  不打印目录
//            if(ff.isFile()){
//                System.out.println(ff.getName());//test.txt
//            }
//        }
//
//    }
//
//}


//File类的删除功能  public boolean delete(); 删除此路径下的文件或目录
//public class Test {
//    public static void main(String[] args) throws IOException {
//        //需求1：在当前文件下创建java.txt文件
////        File f1=new File("D:\\java\\test\\java.txt");
////        System.out.println(f1.createNewFile());//true
//        //需求1：删除在当前文件下的java.txt文件
////        System.out.println(f1.delete());//true
//        //需求三：在当前模块下创建itcast目录
////        File f2=new File("itcast");
////        System.out.println(f2.mkdir());
////        System.out.println(f2.getAbsolutePath());
//        //需求四：删除itcase目录
////        f2.delete();//true
////        //需求五：在当前目录下创建一个itcast目录 并在该目录下创建java.txt文件
////        File f3=new File("D:\\java\\test\\itcast");
////        System.out.println(f3.mkdir());
////        File f4=new File("D:\\java\\test\\itcast//java.txt");
////        System.out.println(f4.createNewFile());
////        //需求六：删除itcast目录且删除里面的所有元素
////        //System.out.println(f3.delete());//false 因为itcast中还有内容  必须先删除其中的内容才行
////        System.out.println(f4.delete());//true
////        System.out.println(f3.delete());//true;
//
//
//
//    }
//}

//利用java求出斐波那契数列
//public class Test {
//    public static void main(String[] args) {
//        int ret=f(20);//6765
//        int rett=f(30);//832040
//        System.out.println(ret);
//        System.out.println(rett);
//    }
//    public static int f(int x){
//        if(x==1||x==2)return 1;
//        return f(x-1)+f(x-2);//多次重复计算但递归速度太慢  因为要进行多次重复计算
//    }
//}


//运用递归遍历目录 如果有子目录 把子目录中的非目录文件路径输出
//public class Test {
//    public static void main(String[] args) {
//        File f1=new File("D:\\java\\test");
//        File[] files = f1.listFiles();
//        if(files!=null) getallpath(files);
//        else System.out.println("null");
//    }
//    public static void getallpath(File[] f){
//        for(File ff:f){
//            if(ff.isDirectory()){
//                getallpath(ff.listFiles());
//            }else{
//                System.out.println(ff.getAbsolutePath());
//            }
//        }
//
//    }
//}

//字节流写对象
/*
InputStream:字节输入流的超类
OuputStream:字节输出流的超类
注：他们的子类名称都都以父类作为后缀
FileOutputStream(String name):将数据写入file
构造方法：FileOutputSreeam(String name);
 */

//public class Test {
//    public static void main(String[] args) throws IOException {
//        FileOutputStream file=new FileOutputStream("D:\\java\\test\\java.txt");
//        /*
//        这个方法做了三件事
//        创建文件java.txt
//        创建字符输出流对象
//        让该对象指向创建好的文件
//         */
//        file.write(97);//在java.txt中写入字符a
//        file.write(69);//在Java.txt中写入字符E
//        //最后要close:关闭此文件输出流并释放与此流关联的所有系统资源。
//        file.close();
//    }
//}

/*
字节流写数据的三种方式：
void write(int b);将指定的字节写入文件输入流 一次写一个数据
void write(byte[] b);将字节数组中的数据全部写入文件
void write(byte[] b,int off,int len);将长度为len的数据从偏移量为off的位置写入文件
 */

//public class Test {
//    public static void main(String[] args) throws IOException {
//        //void write(int b);将指定的字节写入文件输入流 一次写一个数据
//        FileOutputStream f1=new FileOutputStream("D:\\java\\test\\java.txt");
////        f1.write(97);
////        f1.write(98);
////        f1.write(99);
////        f1.write(100);
////        f1.write(101);//后面添加的会覆盖前面的
//        //void write(byte[] b);将字节数组中的数据全部写入文件
////        byte[] b={97,98,99,100};
////        f1.write(b);//abcd
////        byte[] bytes = "abcd".getBytes();
////        f1.write(bytes);
//
//        //void write(byte[] b,int off,int len);将长度为len的数据从偏移量为off的位置写入文件
//        byte[] b={97,98,99,100,101};
//        f1.write(b,1,3);//bcd  从下标为1到下表为3
//        f1.close();//结束  不可少
//
//    }
//}

//字节流写数据实现换行和追加写入
/*
windows操作系统：\r\n
linux操作系统：\n
mac操作系统：\r
//追加
public FileOutputStream(String name,boolean append)
throws FileNotFoundException
创建文件输出流以写入具有指定名称的文件。如果第二个参数是true ，则字节将写入文件的末尾而不是开头
 */
//public class Test {
//    public static void main(String[] args) throws IOException {
//        FileOutputStream fos=new FileOutputStream("D:\\java\\test\\java.txt",true);//append定义为true
//        for(int i=1;i<=10;i++){
//            fos.write("hello".getBytes());
//            fos.write("\r\n".getBytes());
//
//        }
//        fos.close();
//    }
//}


//字节流异常的try..catch处理
//public class Test {
//    public static void main(String[] args) {
////        try {
////            FileOutputStream fos=new FileOutputStream("D:\\java\\test\\java.txt");
////            fos.write("hello".getBytes());
////            fos.close();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }//但是这样如果在创建对象过程中出现异常 则输出流对象不能被close 会展占用资源  所以我们可以用finally
//        FileOutputStream fos=null;
//        try {
//           fos=new FileOutputStream("D:\\java\\test\\java.txt");
//            fos.write("hello".getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally{
//            if(fos!=null) {
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}

/*
字节流读取数据：一次只读取一个数据
构造函数：FileInputStream(String name)	通过打开与实际文件（由文件系统中的路径名命名的文件）的连接来创建。FileInputStreamname
读取方法：int	read()	从此输入流中读取一个字节的数据  数据的下一个字节，或者是否到达文件的末尾。-1
 */

//public class Test {
//    public static void main(String[] args) throws IOException {
//        FileInputStream fis=new FileInputStream("D:\\java\\test\\java.txt");
////        int r1 = fis.read();
////        System.out.println(r1);//104
////        System.out.println((char)r1);//h
////        r1=fis.read();
////        System.out.println((char)r1);//e
//        //利用循环来自动读取文件
//        int r;//r必须定义在外面
//        while( (r = fis.read())!=-1){
//            System.out.print((char)r);//hello  不能用println 避免多余的换行
//        }
//        fis.close();//别忘了
//    }
//}


//字节流复制文件到另一个文件中去
//public class Test {
//    public static void main(String[] args) throws IOException{
//        FileInputStream fis=new FileInputStream("D:\\java\\test\\java.txt");
//        FileOutputStream fos=new FileOutputStream("D:\\java\\test\\java1.txt");
//        int by;
//        while((by=fis.read())!=-1){
//            fos.write(by);
//        }
//        fis.close();
//        fos.close();
//
//    }
//}

/*
字符串读取数据
一次读取一个字节数组
int	read(byte[] b, int off, int len)	将最多字节的数据从此输入流读取到字节数组中。
读取到缓冲区的总字节数，或者由于已到达文件末尾而没有更多数据。-1
 */
//public class Test {
//    public static void main(String[] args) throws IOException{
//        FileInputStream fis=new FileInputStream("D:\\java\\test\\java.txt");
////        byte[] by=new byte[5];
////        int r = fis.read(by);
////       // System.out.println(r);//5
////        //String(byte[] bytes)通过使用平台的默认字符集解码指定的字节数组来构造新字符集。
////        System.out.println(new String(by));//hello 通过by中的字符创建一个字符串
////        r=fis.read(by);
////        System.out.println(new String(by));//wor  没有ld  因为 hello后面还有换行符\r\n
////
////        r=fis.read(by);
////        System.out.println(r);//5
////        System.out.println(new String(by,0,r));//wor  没有ld  因为 hello后面还有换行符\r\n
//
//        byte[] by=new byte[1024];//一般创建1024或其整数倍
//        int r;
//        while((r=fis.read(by))!=-1){
//            System.out.println(new String(by,0,r));//hellon world java
//        }
//        fis.close();
//    }
//}

//字节流复制图片 将电脑上的图片复制到 任意地方官
//public class Test {
//    public static void main(String[] args) throws IOException{
//        FileInputStream fis=new FileInputStream("D:\\1.jpg");
//        FileOutputStream fos=new FileOutputStream("D:\\java\\test\\copy.jpg");
//        int len;
//        byte[] by=new byte[1024];
//        while((len=fis.read(by))!=-1){
//            fos.write(by,0,len);//牛
//        }
//        new FileOutputStream("D:\\java\\test\\copy.jpg");
//        fis.close();
//        fos.close();
//    }
//}
//字节缓冲流
//该类实现缓冲输出流。通过设置这样的输出流，应用程序可以将字节写入基础输出流，而不必为写入的每个字节调用底层系统。
/*
字节缓冲输出流：
构造方法：
BufferedOutputStream(OutputStream out)	创建新的缓冲输出流，以将数据写入指定的基础输出流。
BufferedOutputStream(OutputStream out, int size)创建新的缓冲输出流，以将数据写入具有指定缓冲区大小的指定基础输出流
字节缓冲输入流：
构造方法：
BufferedInputStream(InputStream in)创建并保存其参数，即 输入流 ，供以后使用
BufferedInputStream(InputStream in, int size)创建 具有指定缓冲区大小的 a，并保存其参数（输入流）以供以后使用
 */

//public class Test {
//    public static void main(String[] args) throws IOException {
////        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("D:\\java\\test\\java.txt"));
////        bos.write("hello\r\n".getBytes());
////        bos.write("world\r\n".getBytes());
////        bos.close();
//
//        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("D:\\java\\test\\java.txt"));
//        //一次读取一个数据
////        int by;
////        while((by= bis.read())!=-1){
////            System.out.print((char)by);//不要用println
////        }
//        //一次读取一个字节数组的数据
//        int by;
//        byte[] b=new byte[10];
//        while((by= bis.read(b))!=-1){
//            System.out.print(new String(b,0,by));//不要用println
//        }
//    }
//}
/*
有四种复制文件按的操作
1，基本字节流（即FileOutputStream和FileInputStream）一次只读取一个字节  这种耗时最慢
2，基本直接流一次读写一个字节数组  这种耗时比较快
3，字节缓冲流（即BufferedOutputStream 和 BufferedInputStream）一次读写一个字节 这种耗时较快
4，字节缓冲流一次读取一个字节数组：这种耗时最短
 */

/*
字节流和字符流：
为什么要有字符流：因为字节流操作中文不方便 所以java提供了字符流 字符流=字节流+ 编码表
那么底层是怎么识别中文的呢：汉字在储存的时候 无论时哪种储存方式（UTF-8或GBK 其中UTF-8 中每个中文占三个字节 GBK中每个中文占两个字节)
，第一个字节都是负数 这样 底层读到负数就可以根据它的储存方式来拼接翻译中文
 */
//public class Test {
//    public static void main(String[] args) throws UnsupportedEncodingException {
//        String name="中国";
////        byte[] bytes = name.getBytes();//[-28, -72, -83, -27, -101, -67] 默认采用UTF-8的
////        System.out.println(Arrays.toString(bytes));
//
//        byte[] gbks = name.getBytes("GBK");//[-42, -48, -71, -6] 指定GBK储存方式
//        System.out.println(Arrays.toString(gbks));
//    }
//}

//字符串中的编码和解码 你以何种方式编码就用何种方式解码
//public class Test {
//    public static void main(String[] args) throws UnsupportedEncodingException {
//        String name="中国";
////        byte[] bytes = name.getBytes();//默认UTF-8
////        System.out.println(new String(bytes));//中国  这里
//
////        byte[] gbks = name.getBytes("GBK");
////        String s=new String(gbks,"GBK");
////        System.out.println(s);
//
//        //但是如果编码和解码的方式不同
//        byte[] bytes = name.getBytes("GBK");
//
//        System.out.println(new String(bytes));//�й�  乱码
//
//    }
//}

//字符流中的编码解码问题
/*
字符流抽象基类
Reader:字符输入流的抽象类
Writer:字符输入流的抽象类
字符流中相关的两个类
InputStreamReader 类输入流读取器
OutuputStreamWriter 类输出流读取器
 */
//public class Test {
//    public static void main(String[] args)throws IOException {
//        //OutputStreamReader(InputStream in)创建使用默认字符集的 InputStreamReader。
////        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\java\\test\\java.txt"));
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\java\\test\\java.txt"),"GBK");
//
////        osw.write("hello");
////        osw.write("world");
////        osw.close();//一定要结束掉  否则不能在java.txt中看到输入数据
//       // osw.write("中国");//java.txt中出现中国（这是以系统默认的UTF-8构造的osw）
//        osw.write("中国");//java.txt中出现�й� （这是以系统默认的GBK构造的osw）
//        osw.close();
//       //那么怎么解码出java.txt中的GBK编码呢
////        InputStreamReader isr=new InputStreamReader(new FileInputStream("D:\\java\\test\\java.txt"));
//        InputStreamReader isr=new InputStreamReader(new FileInputStream("D:\\java\\test\\java.txt"),"GBK");
//
//        int len;
//        while((len=isr.read())!=-1){
////            System.out.print((char)len);//�й�（这是以系统默认的UTF-8构造的isr）
//            System.out.print((char)len);//中国（这是以系统默认的GBK构造的oisr）
//        }
//    }
//}


//字符流写数据的5种方法
/*
flush():刷新流，还可以继续写数据
closw():先刷新流，再关闭资源
注意：字符流写数据和字节流写数据不同 字符流写数据数据先是储存在缓存区 需要刷新才能写入文件（因为字符流的底层还是字符流）
 */

//public class Test {
//    public static void main(String[] args) throws IOException {
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\java\\test\\java.txt"));
//        //字符流写数据
//        //方法一：write(int c);写入一个字符
////        osw.write(97);//没刷新前java.txt中没有数据
////        osw.flush();//刷新后java.txt中出现'a'
//        //方法二：write(char[] c):写入一个字符数组
////        char[] c = {'a', 'b', 'c', 'd', 'e'};
////        osw.write(c);
////        osw.flush();//abcde
//        //方法三：写入字符数组中的一部分
////        osw.write(c,1,3);
////        osw.flush();//bcd
//
//        //方法四：write(String str)
////        osw.write("abcde");
////        osw.flush();
//        //方法五:write(String, int off,int len);
//        osw.write("abcde",1,3);
//        osw.flush();//bcd
//        osw.close();
//    }
//}

//字符流读数据的两种方式
/*
int read();一次读取一个字符数据
int read(char[] c);:一次读取一个字符数组数据
 */

//public class Test {
//    public static void main(String[] args) throws IOException {
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\java\\test\\java.txt"));
//        //int read();一次读取一个字符数据
////        int len;
////        while((len=isr.read())!=-1){
////            System.out.print((char)len);//hello world java
////        }
//
//        //int read(char[] c);:一次读取一个字符数组数据
//        int len;
//        char[] c = new char[1024];
//        while ((len = isr.read(c)) != -1) {
//            System.out.println(new String(c, 0, len));//hello world java
//        }
//        isr.close();
//    }
//}
//注:字节流和字符流输入输出差不多  不过一个输入输出的是字符  一个是字节

//FileReader和FileWriter替代InputStreamReader和OutputStreamWriter 法相同 不过前面的更简洁
//public class Test {
//    public static void main(String[] args) throws IOException {
//        FileReader fr = new FileReader("D:\\java\\test\\java.txt");//相比于InputStreamReader FileReader可以直接指定路径
//        FileWriter fw = new FileWriter("D:\\java\\test\\java1.txt");
//        //一个一个字符复制
////        int ch;
////        while((ch=fr.read())!=-1){
////            fw.write(ch);
////        }
////        fr.close();
////        fw.close();
//
//        //用字符数组复制
//        int len;
//        char[] c = new char[1024];
//        while ((len = fr.read(c)) != -1) {
//            fw.write(c, 0, len);
//        }
//        fr.close();
//        fw.close();
//    }
//}

//字符缓冲流
/*
BufferedReadet和BufferedWriter
 */
//public class Test {
//    public static void main(String[] args) throws IOException{
////        BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\java\\test\\java.txt"));
////        bw.write("hello\r\n");
////        bw.write("world\r\n");
////        bw.close();
//        BufferedReader br=new BufferedReader(new FileReader("D:\\\\java\\\\test\\\\java.txt"));
////        int ch;
////        while((ch=br.read())!=-1){
////            System.out.print((char)ch); //hello world
////        }
//        int len;
//        char[] c=new char[1024];
//        while((len=br.read(c))!=-1){
//            System.out.println(new String(c,0,len));
//        }
//        br.close();
//    }
//}


//复制java.txt中的数据到java1.txt中
//public class Test {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br=new BufferedReader(new FileReader("D:\\java\\test\\java.txt"));
//        BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\java\\test\\java1.txt"));
////        int ch;
////        while((ch=br.read())!=-1){
////            bw.write(ch);
////        }
//
//        int len;
//        char[] c=new char[1024];
//        while((len=br.read(c))!=-1){
//            bw.write(c,0,len);
//        }
//        br.close();
//        bw.close();
//    }
//}


//字符缓冲流的特有功能
/*
    BufferedWriter():newLine()	写入行分隔符 分隔符由系统决定 不受系统限制
    BufferedReader():	String readLine()	包含行内容的字符串，不包括任何行终止字符，如果已到达流的末尾而不读取任何字符，则为 null
 */
//public class Test {
//    public static void main(String[] args) throws IOException {
//       // BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\java\\test\\java.txt"));
//        BufferedReader br = new BufferedReader(new FileReader("D:\\java\\test\\java.txt"));
////        bw.write("hello");
////        bw.newLine();//换行
////        bw.write("world");
////        bw.newLine();
//        String s ;
//        while((s=br.readLine())!=null){
//            System.out.println(s);//这里不能用print 因为readLine不会读入换行符
//        }
//       // bw.close();
//        br.close();
//    }
//}

//字符缓冲流的特有功能复制java文件
//public class Test {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br=new BufferedReader(new FileReader("D:\\java\\test\\java.txt"));
//        BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\java\\test\\java1.txt"));
//        String line;
//       while((line=br.readLine())!=null){
//           bw.write(line);//如果没加bw.newLine();  那么新文件中没有换行
//           bw.newLine();
//            bw.flush();
//       }
//       br.close();//这个别忘了
//       bw.close();
//    }
//}

























