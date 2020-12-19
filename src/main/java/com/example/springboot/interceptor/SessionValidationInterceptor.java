package com.example.springboot.interceptor;

import com.example.springboot.dao.DoctorDAO;
import com.example.springboot.dao.UserDAO;
import com.example.springboot.util.RequestContext;
import com.example.springboot.util.ThreadLocal;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class SessionValidationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserDAO userDao;

    @Autowired
    DoctorDAO doctorDao;

    private static SessionValidationInterceptor ourInstance = new SessionValidationInterceptor();

    public static SessionValidationInterceptor getInstance() {
        return ourInstance;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        try {
            RequestContext context = ThreadLocal.safeGet();
            String erResponseStr = StringUtils.EMPTY;
            Integer customerId = context.getCustomerId();
            if (request.getHeader("customerId") != null) {
                if (request.getRequestURI().startsWith("/api/users")) {
                    if (request.getRequestURI().equals("/api/users") && request.getMethod().equals("POST")) {
                        if (!userDao.isAdmin(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }
                    } else if (request.getRequestURI().equals("/api/users") && request.getMethod().equals("GET")) {
                        if (!userDao.isAdmin(customerId) && !userDao.isDoctor(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }
                    } else if (request.getRequestURI().equals("/api/users/id") && request.getMethod().equals("GET")) {
                        if (!userDao.isSelf(Character.getNumericValue(request.getRequestURI().charAt(request.getRequestURI().length() - 1)), customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }

                    } else if (request.getRequestURI().equals("/api/users/id") && request.getMethod().equals("PUT")) {
                        if (!userDao.isSelf(Character.getNumericValue(request.getRequestURI().charAt(request.getRequestURI().length() - 1)), customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }

                    } else if (request.getRequestURI().equals("/api/users/id") && request.getMethod().equals("DELETE")) {
                        if (!userDao.isSelf(Character.getNumericValue(request.getRequestURI().charAt(request.getRequestURI().length() - 1)), customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }

                    }
                } else if (request.getRequestURI().contains("api/patients")) {
                    if (request.getRequestURI().equals("/api/patients") && request.getMethod().equals("POST")) {
                        if (!userDao.isAdmin(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }
                    } else if (request.getRequestURI().equals("/api/patients") && request.getMethod().equals("GET")) {
                        if (!userDao.isAdmin(customerId) && !userDao.isDoctor(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }
                    } else if (request.getRequestURI().equals("/api/patients/id") && request.getMethod().equals("GET")) {
                        if (!userDao.isAdmin(customerId) && !userDao.isDoctor(customerId) || !userDao.isSelf(Character.getNumericValue(request.getRequestURI().charAt(request.getRequestURI().length() - 1)), customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }

                    } else if (request.getRequestURI().equals("/api/patients/id") && request.getMethod().equals("PUT")) {
                        if (!userDao.isDoctor(customerId) && !userDao.isAdmin(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }

                    } else if (request.getRequestURI().equals("/api/patients/id") && request.getMethod().equals("DELETE")) {
                        if (!userDao.isAdmin(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }

                    }
                } else if (request.getRequestURI().startsWith("/api/doctors")) {

                    if (request.getRequestURI().equals("/api/doctors") && request.getMethod().equals("POST")) {
                        if (!userDao.isAdmin(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }
                    } else if (request.getRequestURI().equals("/api/doctors") && request.getMethod().equals("GET")) {
                        if (!userDao.isAdmin(customerId) && !(userDao.isDoctor(customerId) && userDao.isSelf(Character.getNumericValue(request.getRequestURI().charAt(request.getRequestURI().length() - 1)), customerId))) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }
                    } else if (request.getRequestURI().equals("/api/doctors/id") && request.getMethod().equals("GET")) {
                        if (!userDao.isAdmin(customerId) && !(userDao.isDoctor(customerId) && userDao.isSelf(Character.getNumericValue(request.getRequestURI().charAt(request.getRequestURI().length() - 1)), customerId))) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }

                    } else if (request.getRequestURI().equals("/api/doctors/id") && request.getMethod().equals("PUT")) {
                        if (!(userDao.isDoctor(customerId) && userDao.isSelf(Character.getNumericValue(request.getRequestURI().charAt(request.getRequestURI().length() - 1)), customerId)) && !userDao.isAdmin(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }

                    } else if (request.getRequestURI().equals("/api/doctors/id") && request.getMethod().equals("DELETE")) {
                        if (!userDao.isAdmin(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }

                    }
                } else if (request.getRequestURI().startsWith("/api/medicines")) {
                    if (request.getRequestURI().equals("/api/medicines") && request.getMethod().equals("POST")) {
                        if (!userDao.isAdmin(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }
                    } else if (request.getRequestURI().equals("/api/medicines") && request.getMethod().equals("GET")) {
                        if (!userDao.isAdmin(customerId) && !userDao.isDoctor(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }
                    } else if (request.getRequestURI().equals("/api/medicines/id") && request.getMethod().equals("GET")) {
                        if (!userDao.isAdmin(customerId) && !userDao.isDoctor(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }

                    } else if (request.getRequestURI().equals("/api/medicines/id") && request.getMethod().equals("PUT")) {
                        if (!userDao.isDoctor(customerId) && !userDao.isAdmin(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }

                    } else if (request.getRequestURI().equals("/api/medicines/id") && request.getMethod().equals("DELETE")) {
                        if (!userDao.isAdmin(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }

                    }
                } else if (request.getRequestURI().startsWith("/api/diseases")) {
                    if (request.getRequestURI().equals("/api/diseases") && request.getMethod().equals("POST")) {
                        if (!userDao.isAdmin(customerId) && !userDao.isDoctor(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }
                    } else if (request.getRequestURI().equals("/api/diseases") && request.getMethod().equals("GET")) {
                        if (!userDao.isAdmin(customerId) && !userDao.isDoctor(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }
                    } else if (request.getRequestURI().equals("/api/diseases/id") && request.getMethod().equals("GET")) {
                        if (!userDao.isAdmin(customerId) && !userDao.isDoctor(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }

                    } else if (request.getRequestURI().equals("/api/diseases/id") && request.getMethod().equals("PUT")) {
                        if (!userDao.isDoctor(customerId) && !userDao.isAdmin(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }

                    } else if (request.getRequestURI().equals("/api/diseases/id") && request.getMethod().equals("DELETE")) {
                        if (!userDao.isAdmin(customerId) && !userDao.isDoctor(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }

                    }
                } else if (request.getRequestURI().startsWith("/api/dissections")) {
                    if (request.getRequestURI().equals("/api/dissections") && request.getMethod().equals("POST")) {
                        if (!userDao.isAdmin(customerId) && !userDao.isDoctor(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }
                    } else if (request.getRequestURI().equals("/api/dissections") && request.getMethod().equals("GET")) {
                        if (!userDao.isAdmin(customerId) && !userDao.isDoctor(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }
                    } else if (request.getRequestURI().equals("/api/dissections/id") && request.getMethod().equals("GET")) {
                        if (!userDao.isAdmin(customerId) && !userDao.isDoctor(customerId) && !userDao.isPatient(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }

                    } else if (request.getRequestURI().equals("/api/dissections/id") && request.getMethod().equals("PUT")) {
                        if (!userDao.isDoctor(customerId) && !userDao.isAdmin(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }

                    } else if (request.getRequestURI().equals("/api/dissections/id") && request.getMethod().equals("DELETE")) {
                        if (!userDao.isAdmin(customerId) && !userDao.isDoctor(customerId)) {
                            erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                                    "Invalid session api/users",
                                    401
                            );
                        }

                    }
                }
            } else {
                erResponseStr = String.format("{ \"status\": { \"message\": \"%s\", \"code\": %s }}",
                        "Invalid session",
                        401
                );
            }


            if (request.getHeader("customerId") == null) {
                response.getWriter().write(erResponseStr);
                response.setContentType("application/json");
                response.addHeader("Access-Control-Allow-Origin","*");
                response.addHeader("Access-Control-Allow-Headers", "*");
                response.addHeader("Access-Control-Allow-Methods", "*");
                response.addHeader("Access-Control-From-Files", "*");
                return false;
            }
        } catch (Exception exp) {
            return false;
        }

        return true;
    }
}
