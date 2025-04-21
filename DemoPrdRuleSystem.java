import java.util.List;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.function.Predicate;


class Person {
    public String name;
    public String nation;

    public Person(String name, String nation) {
        this.name = name;
        this.nation = nation;
    }}

class ValidationEngine {
    List<Rule> rules = new ArrayList<Rule>();

    public int count_rules() {
        return rules.size();
    }
    public void addRule(Rule rule) {
        rules.add(rule);
    }

    /* coupled to person */
    public int run(Person person) {
        int r = -1;
        for (int i = 0; i < rules.size(); i++) {
            Rule rule = this.rules.get(i);
            int r = rule.check(person);
        }
        return r;
    }
}

interface Rule {
    /* coupled to person */
    public void check(Person person);
}

/* coupled to Person */
class ERule implements Rule {

    /* coupled to Person */
    private Predicate<Person> predicate;

    /* coupled to Person */
    public ERule(Predicate<Person> predicate, String desc) {
        this.predicate = predicate;
    }

    /* coupled to Person */
    public int check(Person person) {
        // 1. data (input)
        // 2. condition (predicate)
        // 3. action
        // System.out.println("x-----------------------"); <<<<<<<<<<<<<<<<<<<<<<<<
        if (predicate.test(person)) {
            System.out.println(1);
            return 1;
        } else {
            System.out.println(2);
            return 2;
        }
        return 0;
        // System.out.println("_______________________");
    }
}

public class DemoPrdRuleSystem {
    public static void main(String[] args) {

        // init  rule engine ------------------------------------------------
        ValidationEngine engine = new ValidationEngine();

        // ------------------------------------------------------------------
        // int rules_size = engine.count_rules();
        // System.out.println(String.format("rules_size ..... %d", rules_size));

        // conditions ------------------------------------------------------- <<<<<<<<<<<<<<<<<
        Predicate<Person> p1 = p -> p.name != null; 
        Predicate<Person> p2 = p -> p.nation != null;

        // one rule per one condition ---------------------------------------
        ERule r1 = new ERule(p1, "...");
        ERule r2 = new ERule(p2, "...");

        // add rule to rule_engine ------------------------------------------
        engine.addRule(r1);
        engine.addRule(r2);

        // rules_size = engine.count_rules();
        // System.out.println(String.format("rules_size ..... %d", rules_size));

        // facts/input/data ------------------------------------------------- <<<<<<<<<<<<<<<<<<<<<<<
        Person person = new Person("person", null);

        // run PRS ----------------------------------------------------------
        int result = engine.run(person);
        System.out.println(result);
    }
}
