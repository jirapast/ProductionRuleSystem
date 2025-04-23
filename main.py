
if __name__ == "__main__":

    from custom_a.actions import myActions
    from custom_a.facts import Person, person
    from custom_a.predicates import predicates
    from RuleEngine import MyRule, Engine

    engine = Engine()

    for predicate in predicates:
        engine.addRule(MyRule(myActions, predicate, "desc1"))
    r = engine.run(person)
    print("custom_a result: ", r)

    # ------------------------------------------------

    from custom_b.actions import myActions
    from custom_b.facts import Person, person
    from custom_b.predicates import predicates
    from RuleEngine import MyRule, Engine

    engine = Engine()

    for predicate in predicates:
        engine.addRule(MyRule(myActions, predicate, "desc1"))
    r = engine.run(person)
    print("custom_b result: ", r)
