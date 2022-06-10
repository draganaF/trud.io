export function setUserId(id) {
  localStorage.setItem('userId', id);
}

export function getUserId() {
  return localStorage.getItem('userId');
}

export function setRole(role) {
  localStorage.setItem('role', role);
}

export function getRole(role) {
  return localStorage.getItem('role', role);
}

export function setPregnancyId(pregnancyId) {
  localStorage.setItem('pregnancyId', pregnancyId);
}

export function getPregnancyId() {
  return localStorage.getItem('pregnancyId');
}