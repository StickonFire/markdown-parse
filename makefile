CLASSPATH = -cp lib/*:.

TryCommonMark.class: TryCommonMark.java
        javac -g -cp $(CLASSPATH) TryCommonMark.java