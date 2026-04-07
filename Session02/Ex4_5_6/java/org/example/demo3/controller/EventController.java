
package Session02.Ex4_5_6.java.org.example.demo3.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/events")
public class EventController {
    @GetMapping("/search")
    public String search(@RequestParam(name = "keyword", required = false) String keyword,
                         HttpServletRequest request) {

        List<Map<String, Object>> events = new ArrayList<>();

        // DATA GIẢ NHƯ DATABASE
        events.add(Map.of(
                "id", 1,
                "name", "Spring Boot Workshop",
                "date", "10/04/2026",
                "price", 0,
                "remainingTickets", 5
        ));

        events.add(Map.of(
                "id", 2,
                "name", "Java Conference",
                "date", "12/04/2026",
                "price", 500000,
                "remainingTickets", 0
        ));

        events.add(Map.of(
                "id", 3,
                "name", "React Summit",
                "date", "15/04/2026",
                "price", 300000,
                "remainingTickets", 50
        ));

        // FILTER GIỐNG REAL
        if (keyword != null && !keyword.isEmpty()) {
            events = events.stream()
                    .filter(e -> e.get("name").toString().toLowerCase()
                            .contains(keyword.toLowerCase()))
                    .toList();
        }

        request.setAttribute("events", events);
        request.setAttribute("keyword", keyword);

        return "search"; // tới search.jsp
    }
}
