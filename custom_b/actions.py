# Many Conditions to one Actions
def myActions(predicate, facts):
    if predicate(facts) is True:
        return 11
    elif predicate(facts) is False:
        return 22 
    else:
        raise Exception