package generics;

public class Wildcards {
    static void rawArgs(Holder holder,Object arg){
        holder.set(arg);
        holder.set(new Wildcards());

        Object obj=holder.get();
    }
    static void unboundedArg(Holder<?> holder,Object arg){
        //err:
       // holder.set(arg);
    }
    static <T> T exact1(Holder<T> holder){
        T t = holder.get();
        return t;
    }
    static<T> T exact2(Holder<T> holder,T arg){
        holder.set(arg);
        T t = holder.get();
        return t;
    }
    static <T> T wildSubtype(Holder<?extends T>holder,T arg){
        T t = holder.get();
        return t;
    }
    static <T> void wildSupertype(Holder<? super T>holder,T arg){
        holder.set(arg);
       Object obj = holder.get();
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Long>();
        raw = new Holder();
        Holder<Long> qualified = new Holder<Long>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();

        Long lng = 1L;
        rawArgs(raw,"eng");
        rawArgs(qualified,lng);
        rawArgs(unbounded,lng);
        rawArgs(bounded,lng);

        unboundedArg(raw,lng);
        unboundedArg(qualified,lng);
        unboundedArg(unbounded,lng);
        unboundedArg(bounded,lng);

        Object r1 = exact1(raw);

    }
}
