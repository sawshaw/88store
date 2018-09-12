package util;

public class Page {              //��¼��ǰҳ��״̬��Ϣ
	private int num;            //��ǰҳ�ţ�������Ȼ����� 1,2,3,...
	private int size;          //һҳ��ʾ���ٸ����
	private int rowCount;     //��¼������Ŀ��һ���ж��ٸ���ݣ�
	private int pageCount;   //ҳ������nҳ��
	private int startRow;    //��ǰҳ��ʼ�кţ���һ����0��  ����ƫ����
	private int first=1;    //��һҳ  ҳ��
	private int last;      //���ҳ  ҳ��
	private int next;     //��һҳ  ҳ��
	private int prev;     //ǰһҳ  ҳ��
	private int start;   // ҳ��ʽ����, ��ʼҳ��
	private int end;     
	private int numCount = 4;     

    public  Page(int size, int str_num, int rowCount) {
    	 
    	int num = 1;
        this.num = num;
        this.size = size;
        this.rowCount = rowCount;
        this.pageCount = (int) Math.ceil((double) rowCount / size); //**��ȡҳ�������,ceil�ǽ�1ȡ��
        this.num = Math.min(this.num, pageCount);    //��ǰҳ�����ֵΪpageCount
        this.num = Math.max(1, this.num);           //��ǰҳ����СֵΪ1
        this.startRow = (this.num-1) * size;       //��ʼ�к�Ϊ 0��
        this.last = this.pageCount;               //���һҳҳ��ΪpageCount
        this.next = Math.min(this.pageCount, this.num+1); //���һҳΪpageCount����Ϊ��ǰҳ+1
        this.prev = Math.max(1, this.num-1);          //��ǰһҳΪ1����Ϊ��ǰҳ-1
        
        start = Math.max(this.num - numCount/2, first); 
        
        end = Math.min(start + numCount, last); 
        if (end - start < numCount) {          
            start = Math.max(end - numCount, 1);
        }
    }
    
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getPrev() {
		return prev;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getNumCount() {
		return numCount;
	}

	public void setNumCount(int numCount) {
		this.numCount = numCount;
	}
}
