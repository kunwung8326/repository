package ex05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex05
 */
@WebServlet("/Ex05")
public class Ex05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex05() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 파라미터 처리 (요청 처리)
		
		// 1) 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2) 파라미터 저장
		
		// Optional 클래스는 자바8부터 지원한다.
		
		/*
		String name = request.getParameter("name");
		Optional<String> opt1 = Optional.of(name);  // Optional.of()는 null이 아닌 인수를 처리한다.
		System.out.println(opt1.get());  // get() 메소드는 Optional에 저장된 인수를 꺼낸다.
		*/
		/*
		String name = request.getParameter("name");
		Optional<String> opt1 = Optional.ofNullable(name);  // Optional.ofNullable()은 null인 인수도 처리한다.
		if (opt1.isPresent()) {  // opt1에 데이터가 존재하면(null이 아니면)
			System.out.println(opt1.get());	
		}
		*/
		/*
		String name = request.getParameter("name");
		Optional<String> opt1 = Optional.ofNullable(name);
		System.out.println(opt1.orElse("기본이름"));  // opt1.orElse("기본이름") : opt1에 값이 있으면 있는 값을 사용하고,
		                                                                        // opt1에 값이 없으면(null이면) "기본이름"을 사용한다.
		String strAge = request.getParameter("age");
		Optional<String> opt2 = Optional.ofNullable(strAge);
		int age = Integer.parseInt(opt2.orElse("0"));
		System.out.println(age);
		*/
		
		Optional<String> opt1 = Optional.ofNullable(request.getParameter("name"));
		String name = opt1.orElse("");  // name이 null이면 빈문자열 사용
		Optional<String> opt2 = Optional.ofNullable(request.getParameter("age"));
		int age = Integer.parseInt(opt2.orElse("0"));  // age가 null이면 0 사용
		
		// 2. 응답 처리
		
		// 1) 응답(response)의 content-type을 결정한다.
		response.setContentType("text/html; charset=utf-8");
		
		// 2) 응답(response)할 수 있도록 출력 스트림을 만든다.
		// 문자 기반 스트림을 사용한다. (HTML문서는 텍스트이기 때문에)
		
		// 문자 기반 출력 스트림
		// FileWriter
		// PrintWriter - 선정 (println() 메소드가 존재하기 때문에)
		// BufferedWriter
		
		// 응답(response)에 출력 스트림을 생성한다.
		PrintWriter out = response.getWriter();
		
		// HTML문서를 만든다.
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>제목</title>");
		out.println("<style>body { color: red; }</style>");
		out.println("<script>alert('반갑습니다.');</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>이름: " + name + "</h3>");
		out.println("<h3>나이: " + age + "</h3>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
