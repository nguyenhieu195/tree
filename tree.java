package tree;
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
        tNode A = new tNode(7, new tNode(1), new tNode(6));
        tNode B = new tNode(5, null, new tNode(9));
        root = new tNode(2, A, B);
    }
    
    void duyet1(tNode T) {
        if (T != null) {
            System.out.println(" " + T.data);
            duyet1(T.left);
            duyet1(T.right);
        }
    }
    
    void duyet2(tNode T) {
        if (T != null) {
            duyet2(T.left);
            System.out.println(" " + T.data);
            duyet2(T.right);
        }
    }
    
    void duyet3(tNode T) {
        if (T != null) {
            duyet3(T.left);
            duyet3(T.right);
            System.out.println(" " + T.data);
        }
    }
    
    void duyetTienTu() { // Duyệt tiền tự: gốc -> con trái -> con phải
        duyet1(root);
    }

    void duyetTrungTu() { // Duyệt trung tự: con trái -> gốc -> con phải
        duyet2(root);
    }
    
    void duyetHauTu() { // Duyệt trung tự: con trái -> con phải -> gốc
        duyet3(root);
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

    int tongnodetrong(tNode t) {
        if (t == null) {
            return 0;
        }
        if (t.left == null && t.right == null) {
            return 0;
        }

        return t.data + tongnodetrong(t.left) + tongnodetrong(t.right);
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
    
    int TinhChieuCao() {
        return tinh_chieu_cao(root);
    }
    
    boolean timX(tNode t, int x){
        if(t == null) {
            return false;
        }
        
        if(t.data == x){
            return true;
        }
        
        if(timX(t.left, x) == false){
            return timX(t.right, x);
        }
        
        return true;
    }

    boolean TimX(int x){
        return timX(root, x);
    }
    
    public static void main(String[] args) {
        tree t = new tree();
        System.out.println("Tạo cây: ");
        t.taoCayT();
        System.out.println("Duyệt tiền tự: ");
        t.duyetTienTu();
        System.out.println("Duyệt trung tự: ");
        t.duyetTrungTu();
        System.out.println("Duyệt hậu tự: ");
        t.duyetHauTu();
        System.out.println("Dếm số node: " + t.DemNode());
        System.out.println("Tổng số node: " + t.SumNode());
    }
}
