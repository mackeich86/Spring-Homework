import ru.appline.logic.Range;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        final Map<String, Range> model = new HashMap<>();
        model.put("N", new Range(316, 45));
        model.put("E", new Range(46, 135));
        model.put("S", new Range(136, 225));
        model.put("W", new Range(226, 315));

        String result = model.entrySet().stream()
                .filter(x -> x.getValue().contains(135))
                .map(x -> x.getKey())
                .collect(Collectors.joining());
        System.out.println(result);
    }
}
