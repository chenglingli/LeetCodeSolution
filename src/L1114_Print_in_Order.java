
/*

Suppose we have a class:

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
The same instance of Foo will be passed to three different threads. Thread A will call first(),
    thread B will call second(), and thread C will call third().

Design a mechanism and modify the program to ensure that second() is executed after first(),
    and third() is executed after second().

Note:

We do not know how the threads will be scheduled in the operating system,
    even though the numbers in the input seem to imply the ordering.
The input format you see is mainly to ensure our tests' comprehensiveness.



Example 1:

Input: nums = [1,2,3]
Output: "firstsecondthird"
Explanation: There are three threads being fired asynchronously.
The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third().
"firstsecondthird" is the correct output.


Example 2:

Input: nums = [1,3,2]
Output: "firstsecondthird"
Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(),
    and thread C calls second().
"firstsecondthird" is the correct output.


Constraints:

nums is a permutation of [1, 2, 3].


 */

import java.util.concurrent.Semaphore;

class Foo {

    private boolean oneDone;
    private boolean twoDone;

    public Foo() {
        oneDone = false;
        twoDone = false;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        oneDone = true;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (!oneDone) {
            wait();
        }
        printSecond.run();
        twoDone = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (!twoDone) {
            wait();
        }
        printThird.run();
    }
}

class Foo2 {

    private Semaphore s1 = new Semaphore(0);
    private Semaphore s2 = new Semaphore(0);

    public Foo2() {}

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s1.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        s2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s2.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

public class L1114_Print_in_Order {

    public static void main(String[] args) throws InterruptedException {

        // 创建共享的 Foo 实例
        final Foo foo = new Foo();

        // 定义三个打印任务
        Runnable printFirst = () -> System.out.print("first");
        Runnable printSecond = () -> System.out.print("second");
        Runnable printThird = () -> {
            System.out.print("third");
            System.out.println(); // 在最后一个打印后换行，方便观察多次运行结果
        };

        // 创建三个线程，分别调用 first, second, third
        // 注意：线程的创建顺序和启动顺序不代表实际执行顺序
        Thread t1 = new Thread(() -> {
            try {
                foo.first(printFirst);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread 1 interrupted");
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                foo.second(printSecond);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread 2 interrupted");
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                foo.third(printThird);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread 3 interrupted");
            }
        });

        // --- 关键：打乱启动顺序来测试 ---
        // 多次运行，可以尝试不同的启动顺序组合，例如：
        System.out.println("Starting threads (Order: t2, t3, t1)...");
        t2.start();
        t3.start();
        t1.start();

        // 或者其他顺序：
        // System.out.println("Starting threads (Order: t3, t1, t2)...");
        // t3.start();
        // t1.start();
        // t2.start();

        // 等待所有线程执行完毕 (可选，但有助于观察完整输出)
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Main thread interrupted while waiting");
        }

        System.out.println("All threads finished.");

        // 你可以把创建和启动线程的部分放到一个循环里跑几次，
        // 或者手动改变 t1, t2, t3.start() 的顺序，
        // 来验证不同并发场景下输出是否稳定为 "firstsecondthird"
    }
}