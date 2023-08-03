import { CanActivateFn } from '@angular/router';

export const adminAuthguardGuard: CanActivateFn = (route, state) => {
  return true;
};
