package com.bdqn.mp.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: {@link MyServlet}
 * Description: TODO SpringBoot支持Servlet
 * 1、同步阻塞方式，发送方向接收方发送请求后，一直等待响应；接收方处理请求时进行的IO操作如果不能马上得到结果，
 * 就一直等到返回结果后，才响应发送方，期间不能进行其他工作。比如，在超市排队付账时，客户（发送方）向收款员（
 * 接收方）付款（发送请求）后需要等待收款员找零，期间不能做其他的事情；而收款员等待收款机返回结果（IO）操作后
 * 才能把零钱取出来交给客户（响应请求），期间也只能等待，不能做其他事情。这种方式实现简单，但是效率不高。
 * 2、同步非阻塞方式，发送方向接收方发送请求后，一直等待响应；接收方处理请求时进行的IO操作如果不能马上得到结果，
 * 就立即返回，去做其他事情，但由于没有得到请求处理结果，不响应发送方，发送方一直等待。一直到IO操作完成后，接收
 * 方获得结果响应发送方后，接收方才进入下一次请求过程。在实际中不使用这种方式。
 * 3、异步阻塞方式，发送方向接收方发送请求后，不用等待响应，可以接着进行其他工作；接收方处理请求时进行的IO操作
 * 如果不能马上得到结果，就一直等到返回结果后，才响应发送方，期间不能进行其他工作。这种方式在实际中也不使用。
 * 4、异步非阻塞方式，发送方向接收方发送请求后，不用等待响应，可以继续其他工作；接收方处理请求时进行的IO操作如
 * 果不能马上得到结果，也不等待，而是马上返回去做其他事情。当IO操作完成以后，将完成状态和结果通知接收方，接收方
 * 再响应发送方。继续使用在超市排队付账的例子。客户（发送方）向收款员（接收方）付款（发送请求）后在等待收款员找
 * 零的过程中，还可以做其他事情，比如打电话、聊天等；而收款员在等待收款机处理交易（IO操作）的过程中还可以帮助客
 * 户将商品打包，当收款机产生结果后，收款员给客户结账（响应请求）。在四种方式中，这种方式是发送方和接收方通信效
 * 率最高的一种。
 *
 * 1.同步与异步针对的是客户端，同步是指客户端要一直等待服务端返回结果，期间不能做其他事情，异步是指客户端无需等待
 * 服务端结果，可以做其他事情

 2.阻塞和非阻塞针对的是服务端，阻塞是指服务端对客户的请求执行系统I/O操作时要等待系统给出结果，期间不能做其他事情，
 非阻塞是指服务端把请求交给系统I/O后，可以做其他事情，并且会轮询查看之前的请求系统是否给出结果，给出就返回，再处
 理下一个，没给出就直接处理下一个

 3.同步非阻塞方式在实际中不使用是因为这样客户对会一直需要等待，因为服务端不会专门开一个线程服务该客户端的请求，
 所以客户端体验是最差的

 4.异步阻塞方式也不在实际中使用是因为客户端可以一直对服务端进行操作，导致服务端压力很大，需要非常多的线程来维护
 请求，所以这要求服务端的性能非常高才行
 * Author: xyf
 * Date 2019/9/10 8:13
 */
@WebServlet(urlPatterns = "/my/servlet", asyncSupported = true)
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        普通形式
//        resp.getWriter().println("hello servlet");
//        异步非阻塞式
//        A filter or servlet of the current chain does not support asynchronous operations.
//        需要设置WebServlet的默认支持异步
        AsyncContext asyncContext = req.startAsync();
        asyncContext.start(() -> {
            try {
                resp.getWriter().println("hello servlet");
                //触发完成
                asyncContext.complete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
