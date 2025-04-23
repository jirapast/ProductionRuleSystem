from .facts import Person

# Conditions
predicate_1 = lambda x: isinstance(x, Person) and x.name == "name1"
predicate_2 = lambda x: isinstance(x, Person) and x.nation == "nation1"
predicate_3 = lambda x: isinstance(x, Person) and x.nation == "nation2"

predicates = [
    predicate_1,
    predicate_2,
    predicate_3,
    ]
