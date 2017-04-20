package test;
public class SynchronizedDemo {
private boolean start=false;
private int result=0;
private int count=0;
 
//读操作
public void write()
{
start=true;
count=10;
 
}
 
//写操作
public void read()
{
if(start)
{
result=count*5;
}
System.out.println("result的值为"+result);
}
class ReadWriteThread extends Thread
{
private boolean state=false;
 
public ReadWriteThread(boolean state)
{
this.state=state;
}
@Override
public void run() {
// TODO Auto-generated method stub
if(state)
{
write();
}
else
{
read();
}
}
}
public static void main(String[] args) {
SynchronizedDemo demo=new SynchronizedDemo();
demo.new ReadWriteThread(true).start();
demo.new ReadWriteThread(false).start();
 
}
}