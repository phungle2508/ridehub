import dayjs from 'dayjs/esm';

import { ISchedule, NewSchedule } from './schedule.model';

export const sampleWithRequiredData: ISchedule = {
  id: '64a7231d-35cf-456b-98ca-3f5cab909dc9',
  departureTime: dayjs('2025-08-30T14:24'),
  arrivalTime: dayjs('2025-08-31T08:12'),
  totalSeats: 4688,
  availableSeats: 1835,
  basePrice: 536.89,
  isActive: true,
  createdAt: dayjs('2025-08-31T10:23'),
  updatedAt: dayjs('2025-08-31T05:15'),
};

export const sampleWithPartialData: ISchedule = {
  id: '64ccdbe0-1668-44f8-bba6-f90008ad05d9',
  departureTime: dayjs('2025-08-30T19:13'),
  arrivalTime: dayjs('2025-08-30T21:09'),
  totalSeats: 3286,
  availableSeats: 18361,
  basePrice: 23366.57,
  isActive: false,
  createdAt: dayjs('2025-08-30T14:11'),
  updatedAt: dayjs('2025-08-30T17:32'),
};

export const sampleWithFullData: ISchedule = {
  id: '5a565d23-7eec-4555-944c-e4838b9fa180',
  departureTime: dayjs('2025-08-30T22:31'),
  arrivalTime: dayjs('2025-08-31T07:05'),
  totalSeats: 1328,
  availableSeats: 6770,
  basePrice: 2126.22,
  isActive: false,
  createdAt: dayjs('2025-08-31T04:07'),
  updatedAt: dayjs('2025-08-30T16:58'),
};

export const sampleWithNewData: NewSchedule = {
  departureTime: dayjs('2025-08-30T16:48'),
  arrivalTime: dayjs('2025-08-30T22:13'),
  totalSeats: 27218,
  availableSeats: 12019,
  basePrice: 30973.85,
  isActive: false,
  createdAt: dayjs('2025-08-30T20:36'),
  updatedAt: dayjs('2025-08-31T09:11'),
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
