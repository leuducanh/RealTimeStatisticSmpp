package viettel.statistic_smpp.work;

import com.viettel.mmserver.base.ProcessThreadMX;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zeromq.ZMsg;
import viettel.statistic_smpp.util.PropertyConfiguration;
import viettel.statistic_smpp.util.context.ApplicationContextProvider;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public abstract class WorkerProcessorManager extends ProcessThreadMX {
    protected ExecutorService threadPool;
    protected static Logger logger = LogManager.getLogger(Worker.class);
    protected final long SLEEP_TIME = 3000;
    protected BlockingQueue<ZMsg> events;

    public WorkerProcessorManager(String threadName, BlockingQueue<ZMsg> events) {
        super(threadName);
        try {
            registerAgent("statistic:type=" + threadName);
        } catch (MalformedObjectNameException ex) {
        } catch (InstanceAlreadyExistsException ex) {
        } catch (MBeanRegistrationException ex) {
        } catch (NotCompliantMBeanException ex) {
        }
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        int coreAmount = ((PropertyConfiguration) ApplicationContextProvider.getBean("myProperty")).number_of_thread_in_thread_pool;
        int overrun = ((PropertyConfiguration) ApplicationContextProvider.getBean("myProperty")).over_run_thread_in_thread_pool;
        threadPool = new ThreadPoolExecutor(coreAmount, coreAmount + overrun, 1, TimeUnit.MINUTES, linkedBlockingQueue);
    }
}
