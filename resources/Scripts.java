import org.jruby.embed.LocalVariableBehavior;
import org.jruby.embed.ScriptingContainer;
import org.python.util.PythonInterpreter;
import sandbox.runtime.Account;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.lang.reflect.Array;
import java.util.Date;
import java.util.jar.Attributes;

/**
 * Basic test suite that allocates heap memory in a bunch of different
 * ways and checks if the allocations are what we expect. Currently
 * doesn't quite do the math properly.
 */
public class Scripts {
    public static String main() throws Exception{

//        PythonInterpreter p = new PythonInterpreter();
//        p.exec("x = 10");
//        ScriptingContainer container = new ScriptingContainer(LocalVariableBehavior.PERSISTENT);
//        container.runScriptlet("p=0.9");
//        container.runScriptlet("x=[0.9] * 10000000000");
//        container.runScriptlet("nil while true");

        ScriptEngineManager engineMgr = new ScriptEngineManager();
        ScriptEngine engine = engineMgr.getEngineByName("JavaScript");
        Bindings bindings = engine.createBindings();

        String script = "(function(){var y = [1, 2, 3, 4, 5]; var x = 0; while(x < 1000000){y.push(1);}; return cow + moo})()";
        bindings.put("cow", 10);
        bindings.put("moo", 20);

        Object obj = engine.eval(script, bindings);

        //container.runScriptlet("x = 'a' * 1000000; puts 'Ruby ' + File.read('.gitignore')");

        return "Success! Nothing broke" + obj;
    }
}
