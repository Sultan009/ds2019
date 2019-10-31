/**
 * Minimum heap s�n�f�
 * @param <T> Generic s�n�f
 */
public class BinaryHeap<T extends Comparable<T>> {
    public T[]  dizi;//Y���n� tutacak dizi(de�i�tirmeyin)
    public int es;//Eleman say�s�(de�i�tirmeyin)

    public BinaryHeap() {//de�i�tirmeyin
        dizi=(T[]) new Comparable[100];
    }
    public BinaryHeap(int boyut){//de�i�tirmeyin
        dizi=(T[])new Comparable[boyut];
    }
    public int ebeveyn(int konum){ return konum/2;}//de�i�tirmeyin, kullan�n
    public int solCocuk(int konum){ return 2*konum;}//de�i�tirmeyin, kullan�n
    public int sagCocuk(int konum){return 2*konum+1;}//de�i�tirmeyin, kullan�n
    public int elemanSayisi(){return es;}

    public void ekle(T eleman){
        // //Bu metodun g�vdesini yaz�n�z
        dizi[++es]=eleman;
        ekleKontrol(es);
    }

    /**
     * Heapify i�lemini �zyinelemeli olarak ekleme i�in kontrol eden i�lem
     * @param konum
     */
    public void ekleKontrol(int konum) {
        if (konum>1 && dizi[konum].compareTo(dizi[ebeveyn(konum)])<0) {
            swap(konum, ebeveyn(konum));
            ekleKontrol(ebeveyn(konum));
        }
    }

    /**
     * Heapify i�lemini silme i�in ger�ekle�tiren �zyinelemeli metod
     * @param konum kontrol edilen eleman konumu
     */
    public void silKontrol(int konum) {
        int sol=solCocuk(konum);
        int sag=sagCocuk(konum);
        if(sol<=es && dizi[konum].compareTo(dizi[sol])>0 ||
           sag<=es && dizi[konum].compareTo(dizi[sag])>0
                ) {
            if(sag>es || dizi[sol].compareTo(dizi[sag])<0) {
                swap(konum, sol);
                silKontrol(sol);
            }
            else {
                swap(konum, sag);
                silKontrol(sag);
            }
        }
    }

    public void swap(int k1, int k2) {
        T gecici=dizi[k1];
        dizi[k1]=dizi[k2];
        dizi[k2]=gecici;
    }

    public T sil(){
        //K�k�(en k���k de�eri) silen metodu yaz�n�z
        T donecek=dizi[1];
        dizi[1]=dizi[es--];
        silKontrol(1);
        return donecek;
    }

}
