            if(front == rear){
                this.noEl = true;
            }
            return true;
                
        } else{
            return false;
        }
    }
    
    public int Front() {
        if(!this.isEmpty()){
            return arrayQueue[front];
        } else{
            return -1;
        }
            
    }
    
    public int Rear() {
        if(!this.isEmpty()){
            if(rear==0){
                return arrayQueue[arrayQueue.length-1];
            } else{
             return arrayQueue[rear-1];
            }
        } else{
            return -1;
        }
    }
    
    public boolean isEmpty() {
        return this.noEl;
    }
    
    public boolean isFull() {
        return (rear == front)  && !this.noEl;
    }
}
​
/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
