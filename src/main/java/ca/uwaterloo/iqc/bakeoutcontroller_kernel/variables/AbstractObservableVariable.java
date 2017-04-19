package ca.uwaterloo.iqc.bakeoutcontroller_kernel.variables;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.exceptions.UnableToSetVariableException;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * Describes a variable to which listeners can be added
 */
public abstract class AbstractObservableVariable<T> extends AbstractMutableVariable<T> implements Observable<T> {
    private final List<WeakReference<VariableChangeEventListener<T>>> listeners;
    private final Executor variableUpdateExecutor;

    public AbstractObservableVariable(T initialValue, Executor variableUpdateExecutor){
        super(initialValue);
        listeners = new LinkedList<>();
        this.variableUpdateExecutor = variableUpdateExecutor;
    }

    @Override
    public void addListener(VariableChangeEventListener<T> listener){
        WeakReference<VariableChangeEventListener<T>> listenerRef = new WeakReference<>(listener);
        this.listeners.add(listenerRef);
    }

    @Override
    public void setValue(T newValue) throws UnableToSetVariableException {
        this.value = newValue;
        notifyListeners(newValue);
    }

    /**
     * Notify the listeners that the variable just changed
     */
    private void notifyListeners(T newValue){
        for (WeakReference<VariableChangeEventListener<T>> ref: this.listeners){
            VariableChangeEventListener<T> listener = ref.get();
            if (listener != null){
                this.variableUpdateExecutor.execute(new OnChangeRunner<>(listener, newValue));
            }
        }
    }

    /**
     * Wraps a call to notify a listener that a variable just changed
     *
     * @param <L> The listener to use
     */
    private class OnChangeRunner<L extends VariableChangeEventListener<T>> implements Runnable {
        /**
         * The listener that will be called in order to carry out the notification
         */
        private final L listener;

        /**
         * The new value of the variable
         */
        private final T newValue;

        /**
         * @param listener The listener to run
         * @param newValue The new value of the variable
         */
        public OnChangeRunner(L listener, T newValue){
            this.listener = listener;
            this.newValue = newValue;
        }

        /**
         * Call {@link VariableChangeEventListener#onChange(Object)}
         */
        @Override
        public void run(){
            this.listener.onChange(newValue);
        }
    }
}
