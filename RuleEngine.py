from abc import abstractmethod, ABC
from typing import Callable


class Rule(ABC):
    @abstractmethod
    def check(self, facts) -> int:
        pass

# Actions
class MyRule(Rule):
    def __init__(self, fn: Callable, predicate: Callable, desc: str):
        self.fn        = fn
        self.predicate = predicate
        self.desc      = desc

    def check(self, facts) -> int:
        return self.fn(self.predicate, facts)

class Engine:
    def __init__(self):
        self.rules = []
    
    def addRule(self, rule: Rule):
        self.rules.append(rule)

    def run(self, facts) -> int:
        r = []
        for rule in self.rules:
            x = rule.check(facts)
            r.append(x)
        return r
