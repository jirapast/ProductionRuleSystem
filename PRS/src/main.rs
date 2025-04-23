struct Facts {
    name: String,
    nation: String,
}

fn main() {

    trait IRule {
        fn check(&self, facts: Facts);
    }

    struct MyRule1 {
        // can this be closure
        // rule_fn: Predicate<>,
    }

    impl IRule for MyRule1 {
        fn check(&self, facts: Facts) {
            
        }
    }

    let fact1 = Facts {
            name: String::from("name1"),
            nation: String::from("nation1"),
        };

    let predicate_1 = |f: Facts| f.name == "name1";
    let predicate_1 = |f: Facts| f.nation== "nation1";


    println!("Hello, world!");
}
