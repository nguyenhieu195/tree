package tree;

import static java.lang.Integer.max;
import static java.lang.Math.abs;
import java.util.Scanner;

class tNode {


    int data;
    tNode left, right;

    tNode(int x) {
        data = x;
        left = right = null;
    }

    tNode(int x, tNode ll, tNode rr) {
        data = x;
        left = ll;
        right = rr;
    }
}

public class tree {

    tNode root;

    void taoCayT() {
        tNode A = new tNode(7, new tNode(11), new tNode(6));
        tNode B = new tNode(0, null, null);
        root = new tNode(2, A, B);
    }

    void duyet_tien_tu(tNode T) {
    if (T != null) {
        System.out.println(" " + T.data);
        duyet_tien_tu(T.left);
        duyet_tien_tu(T.right);
    }
}
    void duyet1(tNode T) {
        if (T != null) {
            System.out.println(" " + T.data);
            duyet_tien_tu(T.left);
            duyet_tien_tu(T.right);
        }
    }

    void duyet_trung_tu(tNode T) {
        if (T != null) {
            duyet_trung_tu(T.left);
            System.out.println(" " + T.data);
            duyet_trung_tu(T.right);
        }
    }

    void duyet_hau_tu(tNode T) {
        if (T != null) {
            duyet_hau_tu(T.left);
            duyet_hau_tu(T.right);
            System.out.println(" " + T.data);
        }
    }
    
    void duyetTienTu() { // Duyệt tiền tự: gốc -> con trái -> con phải
        duyet_tien_tu(root);
    }

    void duyetTrungTu() { // Duyệt trung tự: con trái -> gốc -> con phải
        duyet_trung_tu(root);
    }

    void duyetHauTu() { // Duyệt trung tự: con trái -> con phải -> gốc
        duyet_hau_tu(root);
    }

    int dem(tNode t) {
        if (t == null) {
            return 0;
        } else {
            return 1 + dem(t.left) + dem(t.right);
        }
    }
    int DemNode() {
        return dem(root);
    }

    int sum(tNode t) {
        if (t == null) {
            return 0;
        } else {
            return t.data + sum(t.left) + sum(t.right);
        }
    }

    int SumNode() {
        return sum(root);
    }

    int demsola(tNode t) {
        if (t == null) {
            return 0;
        } else {
            if (t.left == null && t.right == null) {
                return 1;
            } else {
                return demsola(t.left) + demsola(t.right);
            }
        }
    }

    int SoLa() {
        return demsola(root);
    }

    int tongnodetrong(tNode t) { // là node không phải node lá
        if (t == null) {
            return 0;
        }
        if (t.left == null && t.right == null) {
            return 0;
        }

        return t.data + tongnodetrong(t.left) + tongnodetrong(t.right);
    }
    
    int demNodeTrong(tNode t){
        if(t == null){
            return 0;
        }
        else{
            if(t.left != null || t.right != null){
                return 1 + demNodeTrong(t.left) + demNodeTrong(t.right);
            }
        }
        return 0;
    }
    int demNodeTrong(){
        return demNodeTrong(root);
    }

    int TongNodeTrong() {
        return tongnodetrong(root);
    }

    int tongnodele(tNode t) {
        if (t == null) {
            return 0;
        }
        if (t.data % 2 != 0) {
            return t.data + tongnodele(t.left) + tongnodele(t.right);
        }

        return tongnodele(t.left) + tongnodele(t.right);
    }

    int TongNodeLe() {
        return tongnodele(root);
    }

    int dem_so_node_co_1_con(tNode t) {
        if (t == null) {
            return 0;
        }
        if (t.left == null && t.right == null) {
            return 0;
        }
        if (t.left != null && t.right != null) {
            return dem_so_node_co_1_con(t.left) + dem_so_node_co_1_con(t.right);
        }

        return 1 + dem_so_node_co_1_con(t.left) + dem_so_node_co_1_con(t.right);
    }

    int DemSoNodeCo1Con() {
        return dem_so_node_co_1_con(root);
    }

    int tinh_chieu_cao(tNode t) {
        if (t == null) {
            return 0;
        }

        return 1 + Math.max(tinh_chieu_cao(t.left), tinh_chieu_cao(t.right));
    }

    int ChieuCaoCay() {
        return tinh_chieu_cao(root);
    }

    boolean tim_x(tNode t, int x) {
        if (t == null) {
            return false;
        }
        if (t.data == x) {
            return true;
        }
        if (tim_x(t.left, x) == false) {
            return tim_x(t.right, x);
        }
        return true;
    }

    boolean TimX(int x) {
        return tim_x(root, x);
    }
    
    boolean kiem_tra_can_bang(tNode t){
        if(t == null){
            return true;
        }
        if(abs(tinh_chieu_cao(t.left) - tinh_chieu_cao(t.right))> 1){
            return false;
        }
        return kiem_tra_can_bang(t.left) && kiem_tra_can_bang(t.right);
    }
    
    boolean cayCanBang(){
        return kiem_tra_can_bang(root);
    }
    
    int maxNode(tNode t){
        if(t == null){
            return 0;
        }
        return max(t.data, max(maxNode(t.left), maxNode(t.right)));
    }
    
    int MaxNode(){
        return maxNode(root);
    }
    
    int muc_cua_node_x(tNode t, int x, int level){
        return 0;
    }
    public static void main(String[] args) {

        //        2
        //       / \
        //      7   5
        //     / \   \
        //    1   6   9
        Scanner sc = new Scanner(System.in);
        tree t = new tree();
        System.out.println("Tạo cây: ");
        t.taoCayT();

        System.out.println("Duyệt tiền tự: (gốc -> con trái -> con phải)");
        t.duyetTienTu();

        System.out.println("Duyệt trung tự: (con trái -> gốc -> con phải)");
        t.duyetTrungTu();

        System.out.println("Duyệt hậu tự: (con trái -> con phải -> gốc)");
        t.duyetHauTu();

//        System.out.println("Đếm số node: " + t.DemNode());
//
//        System.out.println("Tổng số node: " + t.SumNode());
//
//        System.out.println("Đếm số lá: " + t.SoLa());
//        System.out.println("Đếm số node trong: " + t.demNodeTrong());
//        System.out.println("Tổng node trong: " + t.TongNodeTrong());
//
//        System.out.println("Tổng node lẻ: " + t.TongNodeLe());
//
//        System.out.println("Đếm số node có 1 con: " + t.DemSoNodeCo1Con());
//
//        System.out.println("Chiều cao cây: " + t.ChieuCaoCay());
//
//        System.out.println("--Tìm phần tử trong cây--");
//        int x = 2;
//        if (!t.TimX(x)) {
//            System.out.println("Phần tử không có trong cây.");
//        } else {
//            System.out.println("Phần tử có trong cây.");
//        }
//        
//        System.out.println("Phần tử " + x + " có trong cây: " + t.TimX(x));
//
        System.out.println("Cây cân bằng: " + t.cayCanBang());
//        
//        System.out.println("Phần tử lớn nhất trong cây: " + t.MaxNode());
    }
}
