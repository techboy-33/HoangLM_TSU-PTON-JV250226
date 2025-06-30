import utils.ConnectionDB;

import java.util.Scanner;
import java.sql.*;
import Validator.Validator;

public class MovieManagement {
    public void addMovie(Scanner scanner) {
        String title = Validator.getString(scanner, "Enter title: ");
        String director = Validator.getString(scanner, "Enter director: ");
        int year = Validator.getInt(scanner, "Enter release year: ");

        try (Connection conn = ConnectionDB.getConnection()) {
            CallableStatement stmt = conn.prepareCall("{call add_movie(?, ?, ?)}");
            stmt.setString(1, title);
            stmt.setString(2, director);
            stmt.setInt(3, year);
            stmt.executeUpdate();
            System.out.println("Movie added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listMovies() {
        try (Connection conn = ConnectionDB.getConnection()) {
            CallableStatement stmt = conn.prepareCall("{call list_movies()}");
            ResultSet rs = stmt.executeQuery();
            System.out.println("List of movies:");
            while (rs.next()) {
                System.out.printf("ID: %d | Title: %s | Director: %s | Year: %d%n",
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("director"),
                        rs.getInt("release_year"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateMovie(Scanner scanner) {
        int id = Validator.getInt(scanner, "Enter movie ID to update: ");

        if (!isMovieExists(id)) {
            System.out.println("Movie with ID " + id + " not found.");
            return;
        }

        String title = Validator.getString(scanner, "Enter new title: ");
        String director = Validator.getString(scanner, "Enter new director: ");
        int year = Validator.getInt(scanner, "Enter new release year: ");

        try (Connection conn = ConnectionDB.getConnection()) {
            CallableStatement stmt = conn.prepareCall("{call update_movie(?, ?, ?, ?)}");
            stmt.setInt(1, id);
            stmt.setString(2, title);
            stmt.setString(3, director);
            stmt.setInt(4, year);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Movie updated successfully.");
            } else {
                System.out.println("Movie not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isMovieExists(int id) {
        try (Connection conn = ConnectionDB.getConnection()) {
            CallableStatement stmt = conn.prepareCall("SELECT COUNT(*) FROM movies WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            System.out.println("Error checking movie existence: " + e.getMessage());
        }
        return false;
    }

    public void deleteMovie(Scanner scanner) {
        int id = Validator.getInt(scanner, "Enter movie ID to delete: ");

        if (!isMovieExists(id)) {
            System.out.println("Movie with ID " + id + " not found.");
            return;
        }

        try (Connection conn = ConnectionDB.getConnection()) {
            CallableStatement stmt = conn.prepareCall("{call delete_movie(?)}");
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Movie deleted successfully.");
            } else {
                System.out.println("Failed to delete movie.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
