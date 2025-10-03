<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý chuyến bay</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }

        .container {
            max-width: 1400px;
            margin: 0 auto;
            background: white;
            border-radius: 20px;
            box-shadow: 0 20px 60px rgba(0, 0, 0, 0.3);
            overflow: hidden;
        }

        .header {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 30px 40px;
            text-align: center;
        }

        .header h1 {
            font-size: 2.5em;
            font-weight: 600;
            margin-bottom: 10px;
        }

        .header p {
            font-size: 1.1em;
            opacity: 0.9;
        }

        .search-section {
            background: #f8f9fa;
            padding: 30px 40px;
            border-bottom: 2px solid #e9ecef;
        }

        .search-form {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 15px;
            align-items: end;
        }

        .form-group {
            display: flex;
            flex-direction: column;
        }

        .form-group label {
            font-weight: 600;
            margin-bottom: 8px;
            color: #495057;
            font-size: 0.9em;
        }

        .form-group input {
            padding: 12px 15px;
            border: 2px solid #dee2e6;
            border-radius: 8px;
            font-size: 1em;
            transition: all 0.3s ease;
            background: white;
        }

        .form-group input:focus {
            outline: none;
            border-color: #667eea;
            box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.1);
        }

        .btn-group {
            display: flex;
            gap: 10px;
        }

        .btn {
            padding: 12px 25px;
            border: none;
            border-radius: 8px;
            font-size: 1em;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            text-decoration: none;
            display: inline-block;
            text-align: center;
        }

        .btn-primary {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
        }

        .btn-primary:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(102, 126, 234, 0.4);
        }

        .btn-secondary {
            background: white;
            color: #667eea;
            border: 2px solid #667eea;
        }

        .btn-secondary:hover {
            background: #667eea;
            color: white;
        }

        .content-section {
            padding: 40px;
        }

        .action-bar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 25px;
        }

        .result-count {
            font-size: 1.1em;
            color: #6c757d;
        }

        .btn-add {
            background: linear-gradient(135deg, #11998e 0%, #38ef7d 100%);
            color: white;
            padding: 12px 30px;
            border-radius: 8px;
            text-decoration: none;
            font-weight: 600;
            transition: all 0.3s ease;
            display: inline-block;
        }

        .btn-add:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(17, 153, 142, 0.4);
        }

        .table-container {
            overflow-x: auto;
            border-radius: 12px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.05);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
        }

        thead {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
        }

        th {
            padding: 18px 15px;
            text-align: left;
            font-weight: 600;
            font-size: 0.95em;
            letter-spacing: 0.5px;
        }

        td {
            padding: 15px;
            border-bottom: 1px solid #e9ecef;
        }

        tbody tr {
            transition: all 0.3s ease;
        }

        tbody tr:hover {
            background: #f8f9fa;
            transform: scale(1.01);
        }

        tbody tr:last-child td {
            border-bottom: none;
        }

        .flight-image {
            width: 80px;
            height: 60px;
            object-fit: cover;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
        }

        .status-badge {
            display: inline-block;
            padding: 6px 12px;
            border-radius: 20px;
            font-size: 0.85em;
            font-weight: 600;
        }

        .status-active {
            background: #d4edda;
            color: #155724;
        }

        .status-inactive {
            background: #f8d7da;
            color: #721c24;
        }

        .action-links {
            display: flex;
            gap: 10px;
        }

        .action-links a {
            padding: 8px 15px;
            border-radius: 6px;
            text-decoration: none;
            font-weight: 600;
            font-size: 0.9em;
            transition: all 0.3s ease;
        }

        .btn-edit {
            background: #fff3cd;
            color: #856404;
        }

        .btn-edit:hover {
            background: #ffc107;
            color: white;
        }

        .btn-delete {
            background: #f8d7da;
            color: #721c24;
        }

        .btn-delete:hover {
            background: #dc3545;
            color: white;
        }

        .no-data {
            text-align: center;
            padding: 60px 20px;
            color: #6c757d;
            font-size: 1.1em;
        }

        @media (max-width: 768px) {
            .header h1 {
                font-size: 1.8em;
            }

            .search-form {
                grid-template-columns: 1fr;
            }

            .content-section {
                padding: 20px;
            }

            .action-bar {
                flex-direction: column;
                gap: 15px;
                align-items: stretch;
            }

            table {
                font-size: 0.9em;
            }

            th, td {
                padding: 10px 8px;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h1>✈️ Quản lý chuyến bay</h1>
        <p>Hệ thống quản lý và tra cứu thông tin chuyến bay</p>
    </div>

    <div class="search-section">
        <form action="${pageContext.request.contextPath}/flights" method="get" class="search-form">
            <div class="form-group">
                <label>Tên chuyến bay</label>
                <input type="text" name="flightName" value="${flightName}" placeholder="Nhập tên chuyến bay..."/>
            </div>
            <div class="form-group">
                <label>Điểm xuất phát</label>
                <input type="text" name="startingPoint" value="${startingPoint}" placeholder="Nhập điểm xuất phát..."/>
            </div>
            <div class="form-group">
                <label>Điểm đến</label>
                <input type="text" name="destination" value="${destination}" placeholder="Nhập điểm đến..."/>
            </div>
            <div class="form-group btn-group">
                <button type="submit" class="btn btn-primary">🔍 Tìm kiếm</button>
                <a href="${pageContext.request.contextPath}/flights" class="btn btn-secondary">🔄 Reset</a>
            </div>
        </form>
    </div>

    <div class="content-section">
        <div class="action-bar">
            <div class="result-count">
                📊 Tổng số chuyến bay: <strong>${flights.size()}</strong>
            </div>
            <a href="${pageContext.request.contextPath}/flights/add" class="btn-add">➕ Thêm chuyến bay mới</a>
        </div>

        <div class="table-container">
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên chuyến bay</th>
                    <th>Điểm xuất phát</th>
                    <th>Điểm đến</th>
                    <th>Ngày khởi hành</th>
                    <th>Thời gian</th>
                    <th>Hình ảnh</th>
                    <th>Trạng thái</th>
                    <th>Hành động</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${empty flights}">
                        <tr>
                            <td colspan="9" class="no-data">
                                📭 Không tìm thấy chuyến bay nào
                            </td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="flight" items="${flights}">
                            <tr>
                                <td><strong>#${flight.flightId}</strong></td>
                                <td><strong>${flight.flightName}</strong></td>
                                <td>🛫 ${flight.startingPoint}</td>
                                <td>🛬 ${flight.destination}</td>
                                <td>📅 ${flight.departureDate}</td>
                                <td>⏱️ ${flight.travelTime} ${flight.timeUnit}</td>
                                <td>
                                    <c:if test="${not empty flight.travelImage}">
                                        <img src="${flight.travelImage}" alt="${flight.flightName}" class="flight-image"/>
                                    </c:if>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${flight.status == 1}">
                                            <span class="status-badge status-active">✓ Hoạt động</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="status-badge status-inactive">✗ Không hoạt động</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <div class="action-links">
                                        <a href="${pageContext.request.contextPath}/flights/edit/${flight.flightId}" class="btn-edit">✏️ Sửa</a>
                                        <a href="${pageContext.request.contextPath}/flights/delete/${flight.flightId}" class="btn-delete" onclick="return confirm('Bạn có chắc muốn xóa chuyến bay này?')">🗑️ Xóa</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>