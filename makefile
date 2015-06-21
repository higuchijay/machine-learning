JCC = javac

default: DecisionTreeClassifier.class

DecisionTreeClassifier.class: DecisionTreeClassifier.java classifier.java
	$(JCC) DecisionTreeClassifier.java classifier.java
