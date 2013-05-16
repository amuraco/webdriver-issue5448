package amuraco.bug5448.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView test() {
		return new ModelAndView("home");
	}
	@RequestMapping(value="/wait")
	@ResponseBody
	public void sleep() throws InterruptedException {
		System.out.println("Waiting/sleeping.");
		Thread.sleep(30000L);
		System.out.println("Done.");
	}
}
