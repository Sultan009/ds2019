/**
 * Minimum heap sýnýfý
 * @param <T> Generic sýnýf
 */
public class BinaryHeap<T extends Comparable<T>> {
    public T[]  dizi;//Yýðýný tutacak dizi(deðiþtirmeyin)
    public int es;//Eleman sayýsý(deðiþtirmeyin)

    public BinaryHeap() {//deðiþtirmeyin
        dizi=(T[]) new Comparable[100];
    }
    public BinaryHeap(int boyut){//deðiþtirmeyin
        dizi=(T[])new Comparable[boyut];
    }
    public int ebeveyn(int konum){ return konum/2;}//deðiþtirmeyin, kullanýn
    public int solCocuk(int konum){ return 2*konum;}//deðiþtirmeyin, kullanýn
    public int sagCocuk(int konum){return 2*konum+1;}//deðiþtirmeyin, kullanýn
    public int elemanSayisi(){return es;}

    public void ekle(T eleman){
        // //Bu metodun gövdesini yazýnýz
        dizi[++es]=eleman;
        ekleKontrol(es);
    }

    /**
     * Heapify iþlemini özyinelemeli olarak ekleme için kontrol eden iþlem
     * @param konum
     */
    public void ekleKontrol(int konum) {
        if (konum>1 && dizi[konum].compareTo(dizi[ebeveyn(konum)])<0) {
            swap(konum, ebeveyn(konum));
            ekleKontrol(ebeveyn(konum));
        }
    }

    /**
     * Heapify iþlemini silme için gerçekleþtiren özyinelemeli metod
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
        //Kökü(en küçük deðeri) silen metodu yazýnýz
        T donecek=dizi[1];
        dizi[1]=dizi[es--];
        silKontrol(1);
        return donecek;
    }

}
