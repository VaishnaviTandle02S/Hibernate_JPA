package HibernateJPAProject.dao;

public interface Crud {
    void insert();

    void update();

    void fetchById();

    void fetchAll();

    void remove();
}
