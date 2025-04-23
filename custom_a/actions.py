# Many Conditions to one Actions
def myActions(predicate, facts):
    if predicate(facts) is True:
        return 1
    elif predicate(facts) is False:
        return 0
    else:
        raise Exception