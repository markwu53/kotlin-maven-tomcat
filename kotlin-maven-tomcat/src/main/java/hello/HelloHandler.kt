package hello

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "Hello", value = "/hello")
class HelloHandler : HttpServlet() {
    override fun doGet(req: HttpServletRequest, res: HttpServletResponse) {
        val name = "Mark"
        res.writer.write("""
 <body>
 <h2>
 Hello Kotlin Multi-line String: ${name}
 </h2>
 </body>
		""")
    }
}